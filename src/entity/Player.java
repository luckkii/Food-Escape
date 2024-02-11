package entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
  GamePanel gp;
  KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH){
    this.gp = gp;
    this.keyH = keyH;

    setDefaultValues();
    getPlayerImage();
  }

  public void setDefaultValues() {
    x = 100.0;
    y = 100.0;
    speed = 2;
    direction = "down";
  }

  public void getPlayerImage(){
    try{
      player_image = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      /*
      up2 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      down1 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      down2 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      right1 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      right2 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      left1 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      left2 = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
      */
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  public void update(){
    if(keyH.upPressed == true){
      direction = "up";
      y -= speed;
      System.out.println("check");
    }
    if(keyH.downPressed == true){
      direction = "down";
      y += speed;
      System.out.println("check");

    }
    if(keyH.leftPressed == true){
      direction = "left";
      x -= speed;
      System.out.println("check");

    }
    if(keyH.rightPressed == true){
      direction = "right";
      x += speed;
      System.out.println("check");

    }  
    
    
  }

public void draw(Graphics2D g2) {
	// TODO Auto-generated method stub
	//g2.setColor(Color.white);
    // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
	BufferedImage image = null; 
	
	switch(direction) {
     case "up":
       image = player_image;
       break;
     case "down":
       image = player_image;
       break;
     case "left":
       image = player_image;
       break;
     case "right":
       image = player_image;
       break;
   }
   g2.drawImage(image,(int) x,(int) y, gp.tileSize, gp.tileSize, null);
}
}
