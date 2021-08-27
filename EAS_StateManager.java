// tylermsa

import java.awt.Graphics;
import java.util.Stack;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EAS_StateManager
{
   public Stack<EAS_State> states;
   
   public EAS_StateManager()
   {
      states = new Stack<EAS_State>();
      states.push(new MainState(this));
      
   }  // public EAS_StateManager()
   
   
   public void tick()
   {
      states.peek().tick();
   
   }  // public void tick()
   
   
   public void draw(Graphics g)
   {
      states.peek().draw(g);
      
   }  // public void draw(Graphics g)
   
   
   public void keyPressed(int k)
   {
      states.peek().keyPressed(k);
      
   }  // public void keyPressed(int k)
   
   
   public void keyReleased(int k)
   {
      states.peek().keyReleased(k);
      
   }  // public void keyReleased(int k)
   
   
} //  public class EAS_StateManager