package gameMechanics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import players.Player;

// Gonna be like a figter game
// most of the screen will be visible until i figure out how to have it dynamically move when the "player" gets too close to the edge
// of the screen
public class GameBoard extends JFrame
{
	GameMap map;
	GameThread thread;
	int insetsTop;
	int insetsLeft;
	BufferedImage backBuffer;
	int width;
	int height;
	Player player;
	public GameBoard(int width, int height)
	{
		map = new GameMap(width, height);
		thread = new GameThread(this);
		this.width = width;
		this.height = height;
		
		createFrame(width, height);
		bindKeys();
		
		insetsTop = getInsets().top;
		insetsLeft = getInsets().left;
		backBuffer = new BufferedImage(width + getInsets().right,height + getInsets().bottom,BufferedImage.TYPE_INT_RGB);
		
		player = new Player(0,0, insetsTop,insetsLeft);

		thread.start();
	}
	private void createFrame(int width, int height)
	{
		this.setTitle("Tester Game");
		this.setBounds(0,0,width,height);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void bindKeys()
	{
		JRootPane root = this.getRootPane();
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "pressedUp");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "releasedUp");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "pressedDown");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "releasedDown");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "pressedLeft");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "releasedLeft");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "pressedRight");
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "releasedRight");
		
		AbstractAction pressedUp = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setUp(true);
			}
		};
		AbstractAction releasedUp = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setUp(false);
			}
		};
		
		AbstractAction pressedDown = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setDown(true);
			}
		};
		AbstractAction releasedDown = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setDown(false);
			}
		};
		
		AbstractAction pressedLeft = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setLeft(true);
			}
		};
		AbstractAction releasedLeft = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setLeft(false);	
			}			
		};
		
		AbstractAction pressedRight = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setRight(true);
			}
		};
		AbstractAction releasedRight = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				player.setRight(false);
			}
		};
		root.getActionMap().put("pressedUp",pressedUp);
		root.getActionMap().put("releasedUp",releasedUp);
		
		root.getActionMap().put("pressedDown", pressedDown);
		root.getActionMap().put("releasedDown",releasedDown);
		
		root.getActionMap().put("pressedLeft",pressedLeft);
		root.getActionMap().put("releasedLeft", releasedLeft);
		
		root.getActionMap().put("pressedRight",pressedRight);
		root.getActionMap().put("releasedRight", releasedRight);

	}
	
	public void update()
	{
		player.update();
	}
	public void render()
	{
		Graphics2D g = (Graphics2D)getGraphics();
		Graphics2D bbg = (Graphics2D)backBuffer.getGraphics();
		bbg.clearRect(0, 0, width, height);
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, width, height);
		
		player.render(bbg);
		
		g.drawImage(backBuffer,0,0,this);
	}
	public static void main(String args[])
	{
		GameBoard main = new GameBoard(640,480);
	}
}
