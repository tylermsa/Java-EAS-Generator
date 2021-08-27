// tylermsa

import java.io.*;
import java.io.FileNotFoundException;

import java.awt.Graphics;
import java.awt.*;

public class EAS_Scrolling
{
   private String header;
   private String authority;
   private String hazard;
   private String event;
   private String[] counties;
   private String expiration;
   
   private String reciever;
   
   private int scrollXPos;
   
   private static final Font STANDARD_FONT = AlertState.standardFont;
   
   
   public EAS_Scrolling(String head, String auth, String haz, String ev, String[] counts, String expir, String rec)
   {
      header = head;
      authority = auth;
      hazard = haz;
      event = ev;
      counties = counts;
      expiration = expir;
      reciever = rec;
      
      scrollXPos = 2000;
               
   }  // public EAS_Scrolling(String head, String auth, String haz, String ev, String[] counts, String expir)
   
   
   
   public EAS_Scrolling()
   {
      header = "EMERGENCY ALERT SYSTEM";
      authority = "Primary Entry Point System";
      hazard = "National Periodic";
      event = "Test";
      expiration = "6/03/20 15:00:00 EDT";
      reciever = "EASyPlus";
      
      
      counties = new String[1];
      counties[0] = "District of Columbia, DC";
      
      
      scrollXPos = 2000;
      
   }  // public EAS_Scrolling()
   
   
   public void tick()
   {
      scrollXPos -= EAS_State.charOffset;
      
   }  // public void tick()
   
   
   public void display(Graphics g)
   {
      g.setColor(EAS_Panel.TEXT_COLOR);
      g.setFont(STANDARD_FONT);
      
      String text = toString();
      
      g.drawString(text, scrollXPos, (EAS_Panel.HEIGHT / 2) -240);
      
      if(scrollXPos < (text.length() * 36) * -1 && EAS_Alert.isAiring)
         scrollXPos = 2000;
      
      
   }  // public void display(Graphics g)
   
   
   // toString Method
   
   public String toString()
   {
      String scroll = "";
      
      if(authority.equals("National Weather Service"))
         scroll += "The ";
      else if (authority.equals("Primary Entry Point System"))
         scroll += "A ";
      else
         scroll += "";
      
      scroll += authority + " has issued a ";
      scroll +=  hazard + " " + event;
      scroll += " for the following counties/areas: ";
      
      for(int i = 0; i < counties.length; i++)
      {
         if(i < (counties.length -1))
            scroll += counties[i] + " - ";
         else
            scroll += counties[i] + ". ";
         
      }  // for(int i = 0; i < counties.length -1; i++)
      
      scroll += "Effective until " + expiration + ".     " + reciever;
      
      
      return scroll;
      
      
   }  // public String toString()
   
   
}  // public class EAS_Scrolling