// tylermsa

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

import java.util.Scanner;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFileChooser;

public class AlertState extends EAS_State
{ 
   static Font VCR_EAS; // Monospaced, custom font?
   static Font standardFont;
   static final String FONT = "VCR EAS";
   
   private EAS_Alert alert;
   private EAS_Scrolling scroll;
   
   // Variables to construct the alert
   String header;
   String authority;
   String hazard;
   String event;
   
   String[] counties;
   String expiration;
   String reciever;
   
   Scanner kb = new Scanner(System.in);
   
   
   JFileChooser fileSelection;
   File file;
   
   
   public AlertState(EAS_StateManager mgr)
   {
      super(mgr);
      
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
       
       
      standardFont = new Font(FONT, Font.PLAIN, 60);
      fileSelection = new JFileChooser("");
      
      
   }  // public AlertState(EAS_StateManager mgr)
   
   
   public void init()
   {
      
      // alert = new EAS_Alert();
      // scroll = new EAS_Scrolling();
      
      
   }  // public void init()
   
   
   public void tick()
   {
      if(scroll != null)
         scroll.tick();
      
   }  // public void tick()
   
   
   public void draw(Graphics g)
   {
      g.setColor(EAS_Panel.PANEL_COLOR);
      g.fillRect(0, 0, EAS_Panel.WIDTH, EAS_Panel.HEIGHT);
      
      g.setColor(EAS_Panel.TEXT_COLOR);
      g.setFont(standardFont);
      
      
      if(alert != null)
      {
         alert.display(g);
         scroll.display(g);
      }
      
      // alert.display(g);
      // scroll.display(g);
      
      g.setColor(EAS_Panel.PANEL_COLOR);
      g.fillRect(0, 0, 300, EAS_Panel.HEIGHT); 
      g.fillRect(1300, 0, 300, EAS_Panel.HEIGHT);        
      
      // g.drawRect(100, 100, 100, 100);
   
   }  // public void draw(Graphics g)
   
   
   @Override
   public void keyPressed(int k)
   {
      if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
      {
         // System.out.println("AlertState :: [INFO] : VK_ENTER or VK_SPACE pressed.");
         
         // Open file selection
         fileSelection.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         // fileSelection.showOpenDialog(null);
         
         if(fileSelection.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
         {
            file = fileSelection.getSelectedFile();
            
            try
            {
               FileReader textFile = new FileReader(file);
               BufferedReader reader = new BufferedReader(textFile);
               
               header = reader.readLine();
               authority = reader.readLine();
               hazard = reader.readLine();
               event = reader.readLine();
               
               int affected = Integer.parseInt(reader.readLine());
               counties = new String[affected];
               
               for(int i = 0; i < affected; i++)
                  counties[i] = reader.readLine();
               
               
               expiration = reader.readLine();
               reciever = reader.readLine();
               
               
               alert = new EAS_Alert(header, authority, hazard, event);
               scroll = new EAS_Scrolling(header, authority, hazard, event, counties, expiration, reciever);
               
               
            }
            catch(IOException e)
            {
               System.out.println("AlertState :: [ERROR] : File does not exist or is a non-supported text file.");
               
            }
            
         }  // if(fileSelection.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
         
         
         // Read file and build a new alert and scroll object with given information
         
         
      }  // if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
      
      
   }  // public void keyPressed(int k)
   
   
   @Override
   public void keyReleased(int k)
   {
      if(k == KeyEvent.VK_BACK_SPACE)
      {
         manager.states.pop();
         MainState.change = false;
         
      }  // if(k == KeyEvent.VK_BACK_SPACE)
      
      
   }  // public void keyReleased(int k)
   
   
}  // public class AlertState extends EAS_State