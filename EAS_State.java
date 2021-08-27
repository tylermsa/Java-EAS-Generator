// tylermsa

import java.awt.Graphics;
import java.util.Stack;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class EAS_State
{
   protected EAS_StateManager manager;
   public static double xOffset, yOffset;
   public static double charOffset;
   
   
   public EAS_State(EAS_StateManager mgr)
   {
      manager = mgr;
      
      xOffset = 0;
      yOffset = 0;
      charOffset = 3;
      
      init();
      
   }  // public EAS_State(EAS_StateManager mgr)
   
   
   public abstract void init();
   public abstract void tick();
   public abstract void draw(Graphics g);
   public abstract void keyPressed(int k);
   public abstract void keyReleased(int k);
   
} // public abstract class EAS_State
