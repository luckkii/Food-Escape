package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class KeyHandler implements KeyListener {
  public boolean upPressed, downPressed, leftPressed, rightPressed;
  public boolean gameRunning;

  @Override
  public void keyTyped(KeyEvent e) {
    // Empty implementation

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();

    if (code == KeyEvent.VK_W) {
    	// System.out.println(e.getKeyChar());
    	upPressed = true;
    }
    if (code == KeyEvent.VK_S) {
      downPressed = true;
    }
    if (code == KeyEvent.VK_A) {
      leftPressed = true;
    }
    if (code == KeyEvent.VK_D) {
      rightPressed = true;
    }
    if (code == KeyEvent.VK_R) {
        GamePanel.gameRunning = true;
      }

  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

    if (code == KeyEvent.VK_W) {
    	System.out.println(e.getKeyChar());
    	upPressed = false;
    }
    if (code == KeyEvent.VK_S) {
      downPressed = false;
    }
    if (code == KeyEvent.VK_A) {
      leftPressed = false;
    }
    if (code == KeyEvent.VK_D) {
      rightPressed = false;
    }
    
    
  }
}

