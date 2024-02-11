package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
public class BadFruit {
	GamePanel gp;
	KeyHandler keyH;
  private double x;			//x-coordinate of the center of the ball
  private double y;			//y-coordinate of the center of the ball
  private double diameter;	//diameter of the ball
  private double radius;		//radius of the ball
  private Color color;		//color of the ball
  private double xSpeed;		//x-speed = change in x-position
  private double ySpeed;		//y-speed = change in y-position


  // 2. Create a default constructor
  /**
   * Default Constructor
   * Creates a red ball at (0, 0) with a diameter of 25.  
   * The default speed is 0.
   */
  public BadFruit(GamePanel gp, KeyHandler keyH, int width, int height) {
	  this.gp = gp;
	  this.keyH = keyH;
	  x = (int) (Math.random()*width);
	    y= (int) (Math.random()*height);
    diameter = 25;
    radius = diameter/2;
    xSpeed = (Math.random() * 3) + 0.5;
    ySpeed = (Math.random() * 3) + 0.5;
  }
  public void reset(int width, int height) {
	  x = (int) (Math.random()*width);
	    y= (int) (Math.random()*height);
	    diameter = 25;
	    radius = diameter/2;
	    xSpeed = (Math.random() * 1) + 0.5;
	    ySpeed = (Math.random() * 1) + 0.5;
  }
  // 3. Write a constructor that allows the user to input the parameters (x, y, diameter, Color)
  // and sets the x and y-speed = 0.

     public BadFruit(int ax, int ay, int adiameter) {
       x= ax;
       y = ay;
       diameter = adiameter;
       radius = diameter/2;
       xSpeed = 0;
       ySpeed = 0;
     }



  // 4. Create getters and setters for all private variables

     public double getX() {
       return x;
     }
     public void setX(double ax) {
       x = ax;
     }
     public double getY() {
       return y;
     }
     public void setY(double ay) {
       y = ay;
     }
     public double getDiameter() {
       return diameter;
     }
     public void setDiameter(double aDiameter) {
       diameter = aDiameter;
       radius = aDiameter/2;
     }
     public double getRadius() {
       return radius;
     }
     public void setRadius(double aRadius) {
       radius = aRadius;
       diameter = aRadius*2;
     }
     public Color getColor() {
       return color;
     }
     public void setColor(Color aColor) {
       color = aColor;
     }
     public double getXSpeed() {
       return xSpeed;
     }
     public void setXSpeed(double aXspeed) {
       xSpeed = aXspeed;
     }
     public double getYSpeed() {
       return ySpeed;
     }
     public void setYSpeed(double aYspeed) {
       ySpeed = aYspeed;
     }

  // 5. Finish the following methods
  // 6. Test using BouncingBallTester.java

  public void draw(Graphics2D g2) {
    try {
      g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/player/bad_guy.png")),(int) x,(int) y, gp.tileSize, gp.tileSize, null);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }



  // 7. Sets the center location of the ball
  //    This "teleports" the ball to the given x/y location

  public void setLocation(double xLoc, double yLoc) {
    x = xLoc;
    y = yLoc;

  }



  // 8. Sets the xSpeed and ySpeed to a value between
  // negative maxSpeed and positive maxSpeed
  public void setRandomSpeed(double maxSpeed) {
    xSpeed = (Math.random()*2*maxSpeed)-maxSpeed;
    ySpeed = (Math.random()*2*maxSpeed)-maxSpeed;
    while(xSpeed == ySpeed) {
      ySpeed = (Math.random()*2*maxSpeed)-maxSpeed;
    }
  }


  // 9. Write the move method to make the ball move around the screen
  // and bounce of the edges.
  public void move(int rightEdge, int bottomEdge) {
    x+=xSpeed;
    y+=ySpeed;

    if(y-radius <= 0 ) {
      y = radius;
      ySpeed = ySpeed * -1;
    }

    if(y+radius >= bottomEdge) {
      y = bottomEdge - radius;
      ySpeed = ySpeed * -1;
    }
    if(x-radius <= 0 ) {
      x = radius; 
      xSpeed = xSpeed * -1;
    }

    if(x+radius >= rightEdge) {
      x = rightEdge - radius;
      xSpeed = xSpeed * -1;
    }
  }

public double findDistanceFrom(double x, double y) {
	double xy = Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2);
	double distance = Math.sqrt(xy);
	return distance;
  }

public boolean intersectsWith(Player a) {
	if(findDistanceFrom(a.getX(), a.getY()) <= gp.tileSize) {
	      return true;
	    }
	    else {
	      return false;
	    }

}

}
