package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class GoodFruit {
  GamePanel gp;
    KeyHandler keyH;
    private double x;			
    private double y;			
    private double diameter;	
    private double radius;


    public GoodFruit(GamePanel gp, KeyHandler keyH, int width, int height) {
      this.gp = gp;
      this.keyH = keyH;
      x = (int) (Math.random()*width);
        y= (int) (Math.random()*height);
        radius = gp.tileSize;
  }
    public void reset(int width, int height) {
    	x = (int) (Math.random()*width);
        y= (int) (Math.random()*height);
    }
  public void setLoc(int X, int Y) {
	  x = X;
	  y = Y;
  }

    public void draw(Graphics2D g) {
        try {
          g.drawImage(ImageIO.read(getClass().getResourceAsStream("/player/apple.png")),(int) x,(int) y, gp.tileSize, gp.tileSize, null);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }

}
