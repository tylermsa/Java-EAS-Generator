// tylermsa

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.*;
   
import java.io.File;
import java.io.*;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainState extends EAS_State
{
   static final String HEADER = "EAS DETAILS CHANNEL";
   
   static Font VCR_EAS;
   static Font easStandardFont;
   static final String EAS_FONT = "VCR EAS";
   
   public static boolean change;
   
   
   public MainState(EAS_StateManager mgr)
   {
      super(mgr);
      
      change = false;
      
      try
      {
         VCR_EAS = Font.createFont(Font.TRUETYPE_FONT, new File("VCREAS 3.0.ttf"));
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("VCREAS 3.0.ttf")));
         
      }  // try
      catch(IOException | FontFormatException e)
      {
         System.out.println("MainState :: [ERROR] : Failed to load proper custom font or font file does not exist. Reverting to default font may have occured.");
         
      }  // catch(IOException | FontFormat Exception e)
       
       
      easStandardFont = new Font(EAS_FONT, Font.PLAIN, 60);
      
      
      
   }  // public MainState(EAS_StateManager mgr)
         
   
   public void init()
   {
      // Push a new Alert State with new Alert
      // wait 4 seconds
      // setFocusable(true);
      
      
      
   }  // public void init()
   
   
   public void tick()
   {
      // System.out.println("EAS DETAILS CHANNEL");
      
      
   }  // public void tick()
   
   
   public void draw(Graphics g)
   {
      g.setColor(EAS_Panel.TEXT_COLOR);
      g.setFont(easStandardFont);        
      // g.drawString(HEADER, (EAS_Panel.WIDTH / 2) -325, (EAS_Panel.HEIGHT / 2) -300);
      
      g.drawString(HEADER, (EAS_Panel.WIDTH / 2) -(HEADER.length() * 18) +20, (EAS_Panel.HEIGHT / 2) -300); // CENTERING ALIGNMENT
      
      // g.drawRect((EAS_Panel.WIDTH / 2) -325, (EAS_Panel.HEIGHT / 2) -300, 35, 100);
      // g.drawLine((EAS_Panel.WIDTH / 2), 0, (EAS_Panel.WIDTH / 2), EAS_Panel.HEIGHT);
      
      // 35-36 is char width for VCR EAS
     
     /* 
     if(change)
         manager.states.push(new AlertState(manager));
         */
   
   }  // public void draw(Graphics g)
   
   
   // The simulation will not switch states when space is pressed ?? Help?
   @Override
   public void keyPressed(int k)
   {
      // System.out.println("MainState :: [INFO] : key pressed.");
      
      if(k == KeyEvent.VK_ENTER)
      {
         // System.out.println("MainState :: [INFO] : VK_ENTER pressed.");
      }
      else if(k == KeyEvent.VK_BACK_SPACE)
      {
         System.exit(0);
      }
      
      // change = true;
      
   }  // public void keyPressed(int k)
   
   
   @Override
   public void keyReleased(int k)
   {
      if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
      {
         // System.out.println("MainState :: [INFO] : VK_ENTER released.");
         
         if(!change)
         {
            manager.states.push(new AlertState(manager));
            change = true;
         }
         
      }
      
   }  // public void keyReleased(int k)
   
   // When you press space, this will push the AlertState, and use the enter key to pop the AlertState
   
   
}  // public class MainState extends EAS_State