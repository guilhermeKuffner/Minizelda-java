package zelda1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;



	
	public class Game extends Canvas implements Runnable, KeyListener
	{
		
		
		public static int width = 640, height=480;
		public static int SCALE= 3;
		public Player player;
		public World world;
		public int dir = 1;
		
		public Game() 
		{


			setFocusable(true);
			this.addKeyListener(this);
			this.setPreferredSize(new Dimension(width,height));
			new Spritesheet();
			player = new Player(32,32);
			world = new World();
		}
		
		
		public void tick() 
		{
			player.tick();
			
		}
		
		public void render()
		{
			
			
			BufferStrategy bs = this.getBufferStrategy();
			if(bs==null)
			{
				this.createBufferStrategy(3);
				return;
				
			}
			Graphics g = bs.getDrawGraphics();
			
			g.setColor(new Color(0,135,13));
			g.fillRect(0, 0, width * SCALE, height*SCALE);
			player.render(g);
			world.render(g);
			bs.show();
		}
		
		public static void main(String[] args)
		{
			Game game=new Game();
			JFrame frame = new JFrame();
			frame.add(game);
			frame.setTitle("Zeldinha");
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			new Thread(game).start();
		}
		
		
		@Override
		public void run() 
		{
			while(true)
			{
				
				tick();
				render();
				try 
				{
					Thread.sleep(1000/60);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			
				
			}
		}


		@Override
		public void keyTyped(KeyEvent e) 
		{
			
			
			
		
		}


		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			{
				player.right = true;
				player.dir=1;
				
			}
			else if(e.getKeyCode()== KeyEvent.VK_LEFT)
			{
				player.left = true;
				player.dir=-1;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_DOWN)
			{
				player.down= true;
				player.movfrente =true;
			}
			else if(e.getKeyCode()== KeyEvent.VK_UP)
			{
				player.up = true;
				
			}
		
			
			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			
			if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			{
				player.right = false;
				
				
			}
			if(e.getKeyCode()== KeyEvent.VK_Z)
			{
				player.shoot = true;
				
				
			}
			else if(e.getKeyCode()== KeyEvent.VK_LEFT)
			{
				player.left = false;
			}
			
			if(e.getKeyCode()== KeyEvent.VK_DOWN)
			{
				player.down = false;
				player.movfrente =false;
			}
			else if(e.getKeyCode()== KeyEvent.VK_UP)
			{
				player.up = false;
				
			}
			
			
		}

		


}
