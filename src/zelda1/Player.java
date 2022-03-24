package zelda1;


import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

	public int spd=2;
	public boolean right,down,up,left;
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames=15;
	public boolean movfrente=false;

	public Player(int x, int y)
	{
		super(x,y,32,32);
	}
	public void tick() 
	{
				
		if(right && World.isFree(x+spd, y))
		{
			
			x+=spd;
			}else if (left && World.isFree(x-spd, y))
		{
			x-=spd;
		}
		
		if(up && World.isFree(x, y-spd))
		{
			y-=spd;
		}else if (down && World.isFree(x, y+spd))
		{
			y+=spd;
		}
		if(movfrente==true) {
			curFrames++;
			if(curFrames==targetFrames)
			{
				curFrames=0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_front.length)
				{
					curAnimation=0;
				}
			}
		}
		
		
	}
	public void Movfrent()
	{
		
		
	}
	
	public void render(Graphics g)
	{
		//g.setColor(Color.red );
		//g.fillRect(x, y, width, height);
		
			g.drawImage(Spritesheet.player_front[curAnimation],x,y,32,32,null);
		
		
		
	}

}
