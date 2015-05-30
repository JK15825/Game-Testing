
public class GameThread implements Runnable
{
	GameBoard board;
	public GameThread(GameBoard board)
	{
		this.board = board;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			board.update();
			board.render();
		}
	}
	
}
