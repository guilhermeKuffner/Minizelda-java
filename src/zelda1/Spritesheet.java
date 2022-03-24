package zelda1;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	public static BufferedImage spritesheet;
	
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage block;
	public Spritesheet() {
		
		try {
			spritesheet=ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		block= Spritesheet.getSprite(165, 10, 14, 14);
		player_back=new BufferedImage[2];
		player_back[0] = Spritesheet.getSprite(71, 10, 16, 16);
		player_back[1] = Spritesheet.getSprite(89, 10, 16, 16);
		
		player_front = new BufferedImage[2];
		player_front[0] = Spritesheet.getSprite(1, 10, 16, 16);
		player_front[1] = Spritesheet.getSprite(19, 10, 16, 16);

	}
	public static BufferedImage getSprite(int x,int y, int width,int height)	{
		return spritesheet.getSubimage(x, y, width, height);
		
	}
}
