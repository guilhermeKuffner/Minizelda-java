package zelda1;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

public class Bullet extends Rectangle {
    public int dir = 1;
    public int spd = 8;

    public int frames = 0;
    public Bullet(int x,int y,int dir){
        super(x+16,y,10,10);
        this.dir=dir;
    }
    public void tick(){
        frames++;
        x+=spd*dir;
        if(frames==60){
            Player.bullets.remove(this);
            return;
        }
    }
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);

    }
    
}
