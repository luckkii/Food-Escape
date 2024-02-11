package main;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Entity;
import entity.Key;
import entity.Player;
import entity.Cage;
import entity.GoodFruit;
import entity.BadFruit;
import main.KeyHandler;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements Runnable{
  private Thread gameThread;
  final int originalTileSize = 16;
  final int scale = 4;
  
  public final int tileSize = originalTileSize * scale;
  final int maxScreenCol = 32;
  final int maxScreenRow = 18;
  final int screenWidth = tileSize * maxScreenCol;
  final int screenHeight = tileSize * maxScreenRow;
  private static final int WIDTH = 16*32*3;
  private static final int HEIGHT = 16*18*3;
  public boolean hasKey = false;
  public boolean cageUnlocked = false;
  public static boolean gameRunning = false;
  int FPS = 60;

  KeyHandler keyH = new KeyHandler();
  Thread gameThread1;
  Player player = new Player(this, keyH);
  Key key = new Key(this, keyH, WIDTH, HEIGHT);
  Cage cage = new Cage(this, keyH, WIDTH, HEIGHT);
  BadFruit badguy = new BadFruit(this, keyH, WIDTH, HEIGHT);
  BadFruit badguy2 = new BadFruit(this, keyH, WIDTH, HEIGHT);
  BadFruit badguy3 = new BadFruit(this, keyH, WIDTH, HEIGHT);
  BadFruit badguy4 = new BadFruit(this, keyH, WIDTH, HEIGHT);
  GoodFruit goodguy = new GoodFruit(this, keyH, WIDTH, HEIGHT);

  //Player Default Position
  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 4;
  
public GamePanel(){
  this.setPreferredSize(new Dimension(screenWidth, screenHeight));
  this.setBackground(new Color(96, 152, 108));
  this.setDoubleBuffered(true);
  this.addKeyListener(keyH);
  this.requestFocusInWindow();
  this.setFocusable(true);
}

  public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run(){ 
	 double drawInterval = 1000000000/FPS;
	 double delta = 1;
	 long lastTime = System.nanoTime();
	 long currentTime;
	 
	 while (gameThread != null) {
		 currentTime = System.nanoTime();
		 delta += (currentTime-lastTime) / drawInterval;
		 lastTime = currentTime;
		 if(delta >= 1) {
			 update();
			 repaint();
			 delta--;
		 }
	 }
  }
  public void update(){
    player.update();
  }
  public void paintComponent (Graphics g){
    super.paintComponent(g);
    
    Graphics2D g2 = (Graphics2D)g;
    //text
    if (!gameRunning) {
    	g.setColor(new Color(250,250,250));
        g.setFont(new Font("Serif",Font.BOLD, 30));
        g.drawString("Fruit Escape",WIDTH/2 - 100,HEIGHT/2);
        g.drawString("Press R to Start",WIDTH/3,HEIGHT/2 - 100);
        g.setColor(new Color(250,250,250));
        g.setFont(new Font("Serif",Font.BOLD, 30));
        g.drawString("WASD to move",30,HEIGHT - 30);
        g.drawString("Collect the key to free the good fruit!",30,HEIGHT);
        g.drawString("Don't get hit by the bad foods!",30,HEIGHT + 30);
    }
    if (badguy.intersectsWith(player) || badguy2.intersectsWith(player) || badguy3.intersectsWith(player) || badguy4.intersectsWith(player)) {
    	gameRunning = false;
    	cage.reset(WIDTH, HEIGHT);
    	badguy.reset(WIDTH, HEIGHT);
    	badguy2.reset(WIDTH, HEIGHT);
    	badguy3.reset(WIDTH, HEIGHT);
    	badguy4.reset(WIDTH, HEIGHT);

    	key.reset(WIDTH, HEIGHT);
    	cageUnlocked = false;
    	hasKey = false;
    }
    if (gameRunning) {
    if (key.ifCollides(player)) {
    key.setX(WIDTH + WIDTH);
    hasKey = true;
    }
    key.draw(g2);
    cage.draw(g2);
    if (hasKey && cage.ifCollides(player)) {
    	goodguy.setLoc((int) cage.getX(),(int) cage.getY()); 
    	cage.setX(WIDTH*3);
    	cageUnlocked = true;
    }
    if (cageUnlocked) {
    	goodguy.draw(g2);
    	
    }
    
    badguy.draw(g2);
    badguy2.draw(g2);
    badguy3.draw(g2);
    badguy4.draw(g2);
    badguy.move(WIDTH - 30, HEIGHT - 30);
    badguy2.move(WIDTH - 30, HEIGHT - 30);
    badguy3.move(WIDTH - 30, HEIGHT - 30);
    badguy4.move(WIDTH - 30, HEIGHT - 30);
    player.draw(g2);
    
    player.update();
    }
    else {
    	// g.setColor(new Color(250,250,250));
        // g.setFont(new Font("Serif",Font.BOLD, 30));
        // g.drawString("Game Over",WIDTH/2 - 100,HEIGHT/2);
        // g.drawString("Press R to Restart",WIDTH/3,HEIGHT/2 - 100);
    }
    repaint();
    
    // g2.dispose();
  }
  
}