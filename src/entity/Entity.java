package entity;

import java.awt.image.BufferedImage;

public class Entity {
	  public double x, y;
	  public double speed;

	  public BufferedImage player_image;
	  public String direction;
	

	  public double getY() {
		  return y;
	  }
	  public double getX() {
		  return x;
	  }
	  public double getSpeed() {
		  return speed;
	  }
	  public void setY(int aY) {
		  y = aY;
	  }
	  public void setX(int aX) {
		  x = aX;
	  }
	  public void setSpeed(int aSpeed) {
		  speed = aSpeed;
	  }
}