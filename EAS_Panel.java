// tylermsa

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EAS_Panel extends JPanel implements Runnable, KeyListener
{
   private static final long SERIAL_VERSION_IUD = 1L;
   
   // Dimensions (1:1 or 4:3?) // 1600x900
   // You can change the dimensions, but try not to do any weird ratios
   static final int WIDTH = 1600;
   static final int HEIGHT = 900;
   
   // Runnable Variables
   private Thread thread;
   private boolean isRunning = false;
   
   // fps
   private int fps = 60;
   private long targetTime = 1000 / fps;
   
   // Panel Colors
   static final Color PANEL_COLOR = Color.BLACK; // Change the background color of the alert
   static final Color TEXT_COLOR = Color.WHITE; // Change the text color of the alert
   
   // State Manager
   private EAS_StateManager manager;
   
   
   public EAS_Panel()
   {
      // Set Fullscreen Method?
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      addKeyListener(this);
      setFocusable(true);
      
      
      start();
      
   }  // public GamePanel()
   
   
   private void start()
   {
      isRunning = true;
      thread = new Thread(this);
      thread.start();
      
   }  // private void start()
   
   // Thanks Patrick Feltes for the inspiration of the code
   public void run()
   {
      long start, elapsed, wait;
      manager = new EAS_StateManager();
      
      while(isRunning)
      {
         start = System.nanoTime();
         
         
         tick();
         repaint();
         
         elapsed = System.nanoTime() - start;
         wait = targetTime - elapsed / 1000000;
         
         if(wait <= 0)
            wait = 5;
         
         
         try
         {
            Thread.sleep(wait);
            
         }
         catch(Exception error)
         {
            error.printStackTrace();
            
         }
         
      }  // while(isRunning)
      
   }  // public void run()
   
   
   public void tick()
   {
      // System.out.println("Running");
      // setFocusable(true);
      manager.tick();
      
   }  // public void tick()
   
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setColor(PANEL_COLOR);
      
      g.fillRect(0, 0, WIDTH, HEIGHT);
      
      if(manager != null)
         manager.draw(g);  // ?? What is causing this runtime error? ??
      
   }  // public void paintComponent(Graphics g)
   
   
   
   // reconstruct the thingy ??
   @Override
   public void keyPressed(KeyEvent e)
   {
      // System.out.println("EAS_Panel :: [INFO] : Key pressed.");
      manager.keyPressed(e.getKeyCode());
      
   }  // public void keyPressed(KeyEvent e)
   
   @Override
   public void keyReleased(KeyEvent e)
   {
      // System.out.println("EAS_Panel :: [INFO] : Key released.");
      manager.keyReleased(e.getKeyCode());
      
   }  // public void keyReleased(KeyEvent e)
   
   @Override
   public void keyTyped(KeyEvent e)
   {
      // System.out.println("EAS_Panel :: [INFO] : Key typed.");
      
   }  // public void keyTyped(KeyEvent e)
    
    
} // public class EAS_Panel extends JPanel implements Runnable
