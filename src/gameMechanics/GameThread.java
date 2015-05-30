package gameMechanics;


public class GameThread implements Runnable
{
	GameBoard board;
	Thread thread;
	boolean running;
	public GameThread(GameBoard board)
	{
		this.board = board;
	}
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	public synchronized void stop()
	{
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			System.out.println("It failed inside the stop method:)");
		}
	}
	@Override
	public void run() 
	{
		long lastTime = System.nanoTime();
		long now = 0;
		long nowMilis = 0;
		long lastMilis = 0;

		while(running)
		{
			now = System.nanoTime();
			nowMilis = now / 1000000;
			lastMilis = lastTime / 1000000;
			
			//the lower this is the faster the game will go...
			//250 would be 1/4 of a second... 500 would be a half... 
			if(nowMilis - lastMilis > 200)
			{
				board.update();
				lastTime = now;
			}
			board.render();
		}
	}
	
}
