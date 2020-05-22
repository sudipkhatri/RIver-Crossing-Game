/*
Name: Sudip khatri 
Student ID: s4613222


RiverGUI class creates the panel with all necessary components.
It also assigns the action event to buttons.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//GUI controls for RiverCrossing game, buttons and text fields 
class RiverGUI extends JPanel implements ActionListener {
  private static  boolean gameOver;  
  private JButton clearall, cabbage, wolf, row, goat, reset;  
  private JTextField msgField, PlayerField; 
  private static RiverCrossing river;
  private JLabel wolfLabel, goatLabel,cabbageLabel, northLabel, southLabel, riverLabel,boatLabel; 
  private JPanel p, p1, p2, p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
  private Color panelColour1,panelColour2,textpanelColour; 
  private JTextArea textArea;
  private JScrollPane scrollPane;
  private static int x = 0;
  private static int z = 0;
    
   
 
 // Constructor to create panels, buttons and other GUI components  
 public RiverGUI() {
 
    river = new RiverCrossing();     
    setLayout(new GridLayout(3,1));
    setLayout(new BorderLayout());
    ////adding layout and colors for respective panels   
    panelColour2 = new Color(0, 255, 255);   
    panelColour1 = new Color(102, 255, 102);
    textpanelColour = new Color(255,255,255); //creates a variable for color
 
     //Create panels  
     p = new JPanel(new BorderLayout());
     p1 = new JPanel(); 
     p2 = new JPanel(new GridLayout(6,1));   
     p3 = new JPanel(new GridLayout(3,1));
     p4 = new JPanel();
     p5 = new JPanel();
     p12 = new JPanel();
   //reset panel
     p10 = new JPanel();
   //label panel 
     p11 = new JPanel();
    
     p8 = new JPanel();
     p9 = new JPanel(); 
      
     p6 = new JPanel();
     p7 = new JPanel();
     
     //set background color for panels   
     // for top panels
     p10.setBackground(panelColour1);
     p11.setBackground(panelColour1);
     p4.setBackground(panelColour1); 
     //for middle panels
     p8.setBackground(panelColour2);
     p9.setBackground(panelColour2); 
     p5.setBackground(panelColour2);
     //for bottom panels
     p6.setBackground(panelColour1);
     p7.setBackground(panelColour1); 
     p12.setBackground(panelColour1);
     
 
     //Create text fields and set properties
        
      
      
     msgField = new JTextField("Best Wishes!!!!",40);
     PlayerField = new JTextField("Player Name:",20);
     // to set message field not editable
     msgField.setEditable(false);
     PlayerField.setEditable(true);
     
     //introduction to be printed on the text area as required on assesment
     String str1 ="\tWelcome to the River Crossing Game!!!\n\tFarmer wants to cross the river";
     String str2= " \n\t but he must not leave the cabbage";
     String str3  = "\n\talone with the goat or the goat with the wolf.";
     String str4 = "\n\tYou can:\n\t-Row across by yourself\n\t-Take the cabbage with you\n";
     String str5 = "\t-Take the goat with you\n\t-Take the wolf with you\n\n";
     String str = str1+ str2+str3+str4+str5;
     
     textArea = new JTextArea(str);
   //Make textArea non-editable
     textArea.setEditable(false);
     Font font = new Font("Times", Font.BOLD, 20);
     textArea.setFont(font);
     textArea.setBackground(textpanelColour);
     textArea.setLineWrap(true);
     textArea.setWrapStyleWord(true);
     
     
     scrollPane= new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//Create scrollPane to wrap textArea to make it scrollable
     scrollPane.setPreferredSize(new Dimension(600,800));  
     scrollPane.setVisible(true);


    
     //Create buttons and to set the same size button   
     clearall = new JButton("Clear all");
     cabbage = new JButton("Cabbage");
     wolf = new JButton("Wolf");
     goat = new JButton("Goat");
     row = new JButton("Row");
     reset = new JButton("Reset"); 
     
     //labels
     wolfLabel = new JLabel("Wolf");
     goatLabel = new JLabel("Goat");
     
     cabbageLabel = new JLabel("Cabbage");
     
     northLabel = new JLabel("North Bank");
     southLabel = new JLabel("South Bank");
     riverLabel = new JLabel("River");
     riverLabel.setHorizontalAlignment(JLabel.RIGHT);
     boatLabel = new JLabel("Boat");
     
     //styles for the labels
     wolfLabel.setFont(new Font("Verdana", Font.BOLD, 25));
     goatLabel.setFont(new Font("Verdana", Font.BOLD, 25));
     cabbageLabel.setFont(new Font("Verdana", Font.BOLD, 25));
     boatLabel.setFont(new Font("Verdana", Font.BOLD, 25));
     northLabel.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 25));
     southLabel.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 25));
     riverLabel.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 25));
         
     //Add components to panels   
      
      
     
     p2.add(p10);//label panel
     p2.add(p11); //button panel
     p2.add(p8);
     p2.add(p9);
     p2.add(p6);
     p2.add(p7); 
     //adding buttons 
     p7.add(clearall);
     p7.add(cabbage);
     p7.add(wolf);
     p7.add(goat);
     p7.add(row);
     p1.add(scrollPane);
     //layout
     p.add(p1,BorderLayout.WEST);
     p.add(p2,BorderLayout.CENTER);
     p.add(p3,BorderLayout.EAST);
     p6.add(goatLabel);
     p6.add(wolfLabel);
     p6.add(cabbageLabel);
     p9.add(boatLabel);
     //for side labels
     p5.add(riverLabel);
     p4.add(northLabel);
     p12.add(southLabel);
     p3.add(p4);
     p3.add(p5);
     p3.add(p12);
     //to add msgField, playerField, and resetButton buttons to top panel  
    
     p10.add(msgField);
     p10.add(reset);
     p10.add(PlayerField);
     add(p);
       
    
     
     //dimensions
     p.setPreferredSize(new Dimension(1500,800));
     p1.setPreferredSize(new Dimension(500,800));
     p2.setPreferredSize(new Dimension(800,800));
     p3.setPreferredSize(new Dimension(200,800));
     p6.setPreferredSize(new Dimension(800,100));
     p7.setPreferredSize(new Dimension(800,100));
     p8.setPreferredSize(new Dimension(800,100));
     p9.setPreferredSize(new Dimension(800,100));
     p10.setPreferredSize(new Dimension(800,100));
     p11.setPreferredSize(new Dimension(800,100));
     
     //listeners
     reset.addActionListener(this);
     row.addActionListener(this);
     wolf.addActionListener(this);
     goat.addActionListener(this);
     cabbage.addActionListener(this);
     clearall.addActionListener(this);
     
         
 
     
    

    }// end of actionPerformed method
       public void errormessages()   
   {
      x= river.getErrornum();//get error code from river object
      if (x == 1){
         msgField.setText("Congratulations you won!!!");
      }
      else if (x == 11){
         msgField.setText("I don't see the item in the bank");
      }
      else if (x == 13){
         msgField.setText("The wolf ate the goat! \n ***End of the game");
      }
      else if (x == 12){
         msgField.setText("\nThe goat ate the cabbage");
      }
      else if (x == 14){
         msgField.setText("The goat ate the cabbage and the wolf ate the goat! \n ***End of the game***");
      }
      else if (x == 0){
         msgField.setText("Your move was successful!!!");
      }
   }
   
   public static void errors_counter()
   {
      if (x == 1 || x == 12 || x == 13 || x == 14)
      {
         z += 1;
      }  
   
   }


    public void actionPerformed(ActionEvent e)  {
   
       msgField.requestFocus();//msgFieldset to a focused state 
       
       //Creates the processes of resetButton 
         if (e.getSource() == reset) {
         msgField.setText("Restarting game...");
         PlayerField.setText("Player Name: ");
         
         river.check();
         river.reset();
         
         river.locate();
         
         z = 0;
        
         
         p.removeAll();
         p.revalidate();
         p.repaint();
         p2.add(p10);
         p2.add(p11); 
         p2.add(p8);
         p2.add(p9);
         p2.add(p6);
         p2.add(p7); 
     //adding buttons 
         p7.add(clearall);
         p7.add(cabbage);
         p7.add(wolf);
         p7.add(goat);
         p7.add(row);
         p1.add(scrollPane);
     //layout
         p.add(p1,BorderLayout.WEST);
         p.add(p2,BorderLayout.CENTER);
         p.add(p3,BorderLayout.EAST);
         p6.add(goatLabel);
         p6.add(wolfLabel);
         p6.add(cabbageLabel);
         p9.add(boatLabel);
     //for side labels
         p5.add(riverLabel);
         p4.add(northLabel);
         p12.add(southLabel);
         p3.add(p4);
         p3.add(p5);
         p3.add(p12);
     
         p10.add(msgField);
         p10.add(reset);
         p10.add(PlayerField);
         add(p);
         p.revalidate();
         p.repaint();
         

       }
       
       //Creates the processes of clearallButton 
       if (e.getSource() == clearall) {
         
         
       }
       
       //Creates the processes of row button 
       if (e.getSource() == row) {
       errormessages();
         if (x== 0 || x == 11) {
            river.row(1);
            river.check();
            river.locate();
            errormessages();
            if (x == 0) {
               String code = "boat";
               
               if (river.getItemStatus(code) == 1){
                  p8.add(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.remove(boatLabel);
                  p9.revalidate();
                  p9.repaint();
      
                  }
               else if (river.getItemStatus(code) == 0) {
                  p8.remove(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.add(boatLabel);
                  p9.revalidate();
                  p9.repaint();
                  }
                  
            }
         }
         errors_counter();
         if (z < 2)
         {         
            if (x == 1 || x == 12 || x == 13 || x == 14)
            {
               String code = "boat";

               if (river.getItemStatus(code) == 1){
                  
                  p8.add(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.remove(boatLabel);
                  p9.revalidate();
                  p9.repaint();
      
                  }
               else if (river.getItemStatus(code) == 0) {
                  p8.remove(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.add(boatLabel);
                  p9.revalidate();
                  p9.repaint();
                  }
                  
            }               
            }
             
          }
       

              
       //Creates the processes of wolf button 
         if (e.getSource() == wolf) {
            errormessages();
            if (x == 0){
               river.row(4);
               river.check();
               river.locate();
               errormessages();
               if (x == 0){
               String code = "wolf";
               
                  if (river.getItemStatus(code) == 1){
                  
                  p11.add(wolfLabel);
                  p11.revalidate();
                  p11.repaint();
                  p6.remove(wolfLabel);
                  p6.revalidate();
                  p6.repaint();
                  p8.add(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.remove(boatLabel);
                  p9.revalidate();
                  p9.repaint();

                  }
                else if (river.getItemStatus(code) == 0){
                     p6.add(wolfLabel);
                     p6.revalidate();
                     p6.repaint();
                     p11.remove(wolfLabel);
                     p11.revalidate();
                     p11.repaint();
                     p8.remove(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.add(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                     
                     }
              }
         }
         errors_counter();
         if (z < 2)
         {
            if (x == 1 || x == 12 || x == 13 || x == 14)
            {
               String code = "wolf";
              
               
                  if (river.getItemStatus(code) == 1){
                     p11.add(wolfLabel);
                     p11.revalidate();
                     p11.repaint();
                     p6.remove(wolfLabel);
                     p6.revalidate();
                     p6.repaint();
                     p8.add(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.remove(boatLabel);
                     p9.revalidate();
                     p9.repaint();

                     }
                else if (river.getItemStatus(code) == 0) {
                     p6.add(wolfLabel);
                     p6.revalidate();
                     p6.repaint();
                     p11.remove(wolfLabel);
                     p11.revalidate();
                     p3.repaint();
                     p8.remove(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.add(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                     
                     }
            }
          }
       }//end of wolf button
       
       //Creates the processes of goat button 
       
        if (e.getSource() == goat) {
         errormessages();
         if (x == 0){
            river.row(3);
            river.check();
            river.locate();
            errormessages();
            if (x == 0){
               String code = "goat";
               
               if (river.getItemStatus(code) == 1){
                     p11.add(goatLabel);
                     p11.revalidate();
                     p11.repaint();
                     p6.remove(goatLabel);
                     p6.revalidate();
                     p6.repaint();
                     p8.add(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.remove(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                     }
                else if (river.getItemStatus(code) == 0) {
                     p6.add(goatLabel);
                     p6.revalidate();
                     p6.repaint();
                     p11.remove(goatLabel);
                     p11.revalidate();
                     p11.repaint();
                     p8.remove(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.add(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                     
                     }
               }
         }
         errors_counter();
         if (z < 2)
         {
            if (x == 1 || x == 12 || x == 13 || x == 14)
            {
               String code = "goat";
              
               
               if (river.getItemStatus(code) == 1){
                     p11.add(goatLabel);
                     p11.revalidate();
                     p11.repaint();
                     p6.remove(goatLabel);
                     p6.revalidate();
                     p6.repaint();
                     p8.add(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.remove(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                  }
                else if (river.getItemStatus(code) == 0) {
                  p6.add(goatLabel);
                  p6.revalidate();
                  p6.repaint();
                  p11.remove(goatLabel);
                  p11.revalidate();
                  p11.repaint();
                  p8.remove(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.add(boatLabel);
                  p9.revalidate();
                  p9.repaint();
                  
                  }
                  
            }
         }
       }//end of goat button
       //create the action for cabbage button
         if (e.getSource() == cabbage) {
         errormessages();
            if (x == 0){
               river.row(2);
               river.check();
               river.locate();
               errormessages();
               if (x == 0){
                 String code = "cabbage";
               
                  if (river.getItemStatus(code) == 1){
                     p11.add(cabbageLabel);
                     p11.revalidate();
                     p11.repaint();
                     p6.remove(cabbageLabel);
                     p6.revalidate();
                     p6.repaint();
                     p8.add(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.remove(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                  }
                  else if (river.getItemStatus(code) == 0) {
                     p6.add(cabbageLabel);
                     p6.revalidate();
                     p6.repaint();
                     p11.remove(cabbageLabel);
                     p11.revalidate();
                     p11.repaint();
                     p8.remove(boatLabel);
                     p8.revalidate();
                     p8.repaint();
                     p9.add(boatLabel);
                     p9.revalidate();
                     p9.repaint();
                     }
             }
         }
         errors_counter();
         if (z < 2)
         {
            if (x == 1 || x == 12 || x == 13 || x == 14)
            {
               String code = "cabbage";
               
               if (river.getItemStatus(code) == 1){
                  p11.add(cabbageLabel);
                  p11.revalidate();
                  p11.repaint();
                  p6.remove(cabbageLabel);
                  p6.revalidate();
                  p6.repaint();
                  p8.add(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.remove(boatLabel);
                  p9.revalidate();
                  p9.repaint();
                  }
                else if (river.getItemStatus(code) == 0) {
                  p6.add(cabbageLabel);
                  p6.revalidate();
                  p6.repaint();
                  p11.remove(cabbageLabel);
                  p11.revalidate();
                  p11.repaint();
                  p8.remove(boatLabel);
                  p8.revalidate();
                  p8.repaint();
                  p9.add(boatLabel);
                  p9.revalidate();
                  p9.repaint();
                  }
                  
               }
               
           }


      }//end of cabbage button
   }//end of action event
}//end of RiverGUI class