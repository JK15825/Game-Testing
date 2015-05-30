import javax.swing.JFrame;

// Gonna be like a figter game
// most of the screen will be visible until i figure out how to have it dynamically move when the "player" gets too close to the edge
// of the screen
public class GameBoard extends JFrame
{
	GameMap map;
	GameThread thread;
	int insetsTop;
	int insetsRight;
	public GameBoard(int width, int height)
	{
		map = new GameMap(width, height);
		thread = new GameThread(this);
		
		createFrame(width, height);
		insetsTop = getInsets().top;
		insetsRight = getInsets().right;
	}
	private void createFrame(int width, int height)
	{
		this.setTitle("Tester Game");
		this.setBounds(0,0,width,height);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void update()
	{}
	public void render()
	{}
	public static void main(String args[])
	{
		GameBoard main = new GameBoard(640,480);
	}
}
