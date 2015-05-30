package gameMechanics;

import players.Player;

public class GameMap 
{
	int map[][];
	int screenWidth;
	int screenHeight;
	public GameMap(int width, int height)
	{
		 map = new int[width/8][height/8];
		 screenWidth = width;
		 screenHeight = height;
	}
	public void update()
	{
	}
}
