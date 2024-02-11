package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
public class Cage {
	GamePanel gp;
	KeyHandler keyH;
  private double x;			
  private double y;			
  private double diameter;	
  private double radius;

  public Cage(GamePanel gp, KeyHandler keyH, int width, int height) {
	this.gp = gp;
	this.keyH = keyH;
	x = (int) (Math.random()*width);
    y= (int) (Math.random()*height);
    radius = 32;
  }
  public void reset(int width, int height) {
	  x = (int) (Math.random()*width);
	    y= (int) (Math.random()*height);
	    radius = 32;
  }
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(int aX) {
	  x = aX;
  }
public double findDistanceFrom(double x, double y) {
	double xy = Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2);
	double distance = Math.sqrt(xy);
	return distance;
  }

public boolean ifCollides(Player a){
	if(findDistanceFrom(a.getX(), a.getY()) <= gp.tileSize) {
	      return true;
	    }
	    else {
	      return false;
	    }
}
public void draw(Graphics2D g) {
    try {
      g.drawImage(ImageIO.read(getClass().getResourceAsStream("/player/cage.png")),(int) x,(int) y, gp.tileSize, gp.tileSize, null);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


}

}
