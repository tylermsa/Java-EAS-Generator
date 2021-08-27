// tylermsa   Java EAS Generator   May 27. 2020

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class EAS_Generator
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("EAS Generator (Last Updated 6/3/2020)");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLayout(new BorderLayout());
      frame.add(new EAS_Panel(), BorderLayout.CENTER);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      // Set Fullscreen Method?
      
   }  // main


}  // public class EAS_Generator