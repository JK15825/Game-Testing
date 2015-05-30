package players;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player 
{
// X AND Y ARE RELATIVE TO THE GAME SCREEN
	int x;
	int y;
	boolean up;
	boolean down;
	boolean right;
	boolean left;
	
	int insetsTop;
	int insetsLeft;
	
	public Player(int x, int y, int insetsTop, int insetsLeft)
	{
		this.x = x;
		this.y = y;
		
		up = false;
		down = false;
		right = false;
		left = false;
		
		this.insetsTop = insetsTop;
		this.insetsLeft = insetsLeft;
	}
	public void update() 
	{
		if(up && right)
		{
			x++;
			y--;
		}
		else if(up && left)
		{
			x--;
			y--;
		}
		else if(down && right)
		{
			x++;
			y++;
		}
		else if(down && left)
		{
			x--;
			y++;
		}
		else
		{
			if(up)
			{
				y--;
			}
			else if(down)
			{
				y++;
			}
			if(right)
			{
				x++;
			}
			else if(left)
			{
				x--;
			}
		}
		
		
	}
	public void render(Graphics2D bbg) 
	{
		bbg.setColor(Color.black);
		bbg.fillRect(x*8 + insetsLeft, y*8 + insetsTop, 16, 16);
	}
	public void setUp(boolean b)
	{
		up = b;
	}
	public void setDown(boolean b)
	{
		down = b;
	}
	public void setRight(boolean b)
	{
		right = b;
	}
	public void setLeft(boolean b)
	{
		left = b;
	}


}
