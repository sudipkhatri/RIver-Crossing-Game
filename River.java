/*
Name: Sudip khatri 
Student ID: s4613222


RiverGUI class creates the panel with all necessary components.
It also assigns the action event to buttons.
*/

import java.awt.*;
import javax.swing.*;
//Create JFrame container
public class River
{
   public static void main(String[] args)
   //main method
   {
      JFrame frame = new JFrame("River Crossing Game");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RiverGUI());//create GUI
      frame.pack();
      frame.setVisible(true);
     
    }//end of main method
}//end River class