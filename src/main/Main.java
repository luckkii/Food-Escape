package main;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Entity;
import entity.Player;
import main.KeyHandler;

public class Main {
  public static void main(String[] args) {
  JFrame window = new JFrame();
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Food Escape");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();
    //System.out.println();
    
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
  
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}
