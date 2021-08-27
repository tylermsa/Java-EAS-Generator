// tylermsa

import java.io.*;
import java.io.FileNotFoundException;

import java.awt.Graphics;
import java.awt.*;

public class EAS_Alert
{
   // Instance Vairables
   
   private String header;
   private String authority;
   private String hazard;
   private String event;   // Warning/ Watch/ Advisory
   
   // Only for the scrolling object
   private String[] counties;
   private String expiration;
   
   private static String[] events = { "Notification", "Emergency", "Warning", "Message", "Watch", "Statement", "Test", "Advisory" };   // Priority events
   
   public static boolean isAiring;
   
   private EAS_Scrolling scrollText;
   
   private static final Font STANDARD_FONT = AlertState.standardFont;
   
   
   // Constructors
   
   public EAS_Alert(String head, String auth, String haz, String ev)
   {
      
      header = head;
      authority = auth;
      hazard = haz;
      event = ev;
      
      isAiring = false;
      
   }  // public EAS_Alert(String head, String auth, String haz, String ev)
   
   
   public EAS_Alert(String head, String auth, String haz, String ev, EAS_Scrolling scroll)
   {
      
      header = head;
      authority = auth;
      hazard = haz;
      event = ev;
      scrollText = scroll;
      
      
      isAiring = false;
      
   }  // public EAS_Alert(String head, String auth, String haz, String ev, EAS_Scrolling scroll)
   
   
   public EAS_Alert()   // Extraneous
   {
      header = "EMERGENCY ALERT SYSTEM";
      authority = "Primary Entry Point System";
      hazard = "National Periodic";
      event = "Test";
      
      scrollText = new EAS_Scrolling();
      
      
      isAiring = false;
      
   }  // public EAS_Alert()   // Extraneous
   
   
   // Methods
   
   public void display(Graphics g)
   {  
      g.setColor(EAS_Panel.TEXT_COLOR);
      g.setFont(STANDARD_FONT);
      
      isAiring = true;
      g.drawString(header, (EAS_Panel.WIDTH / 2) -(header.length() * 18) +20, (EAS_Panel.HEIGHT / 2) -300);
      g.drawString(authority, (EAS_Panel.WIDTH / 2) -(authority.length() * 18) +20, (EAS_Panel.HEIGHT / 2) -120);
      g.drawString("Issued a", (EAS_Panel.WIDTH / 2) -(8 * 18) +20, (EAS_Panel.HEIGHT / 2) -0);
      
      //
      if((hazard.length() + event.length() +1) >= 24)
      {
         g.drawString(hazard, (EAS_Panel.WIDTH / 2) -(hazard.length() * 18) +20, (EAS_Panel.HEIGHT / 2) +120);
         g.drawString(event, (EAS_Panel.WIDTH / 2) -(event.length() * 18) +20, (EAS_Panel.HEIGHT / 2) +180);
      }
      else
         g.drawString((hazard + " " + event), (EAS_Panel.WIDTH / 2) -((hazard.length() + event.length() +1) * 18) +20, (EAS_Panel.HEIGHT / 2) +120);
         
   }  // public void display(Graphics g)
   
   
   // Return Variables
   
   public String getHeader()
   {
      return header;
      
   }  // public String getHeader()
   
   
   public String getAuthority()
   {
      return authority;
   
   }  // public String getAuthority()
   
   
   public String getHazard()
   {
      return hazard;
      
   }  // public String getHazard()
   
   
   public String getEventType()
   {
      return event;
   
   }  // public String getEventType()
   
   
   // toString Method
   
   public String toString()
   {
      return authority + " issued a " + hazard + " " + event;
   
   }  // public String toString()
   
   
}  // public class EAS_Alert