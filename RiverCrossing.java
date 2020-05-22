/*
Name: Sudip khatri 
Student ID: s4613222


RiverGUI class creates the panel with all necessary components.
It also assigns the action event to buttons.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiverCrossing {
	
	int item_size = 4;
	//int i = 0;
	//boolean or int array as place holders for farmer's items
			// False - item located on South Bank of river
			// True - item located on North Bank of river
	public static Boolean[] Bank = new Boolean[4];
	private static String [] northbank = new String[4];
	private static String [] southbank = new String[4];
    private static int itemstatus;
   
    private static int num;
   
  
	
	private String[] item = {"boat", "cabbage", "goat", "wolf"};
	//private List<String> item_list = new ArrayList<String>();

	//RiverCrossing constructor 
	// sets southbank item to false 
	public RiverCrossing() {
		Arrays.fill(this.Bank, false);
	}
	
	public Boolean[] getBool() {
		return Bank;
	}
	
	public String[] getitem() {
		return item;
	}
	
	int check() {
		int num = 0;
		int i = 0;
		//The wolf ate the goat, end of the game
		if ((Bank[0]==true && Bank[1]==true && Bank[2]==false && Bank[3]==false) || (Bank[0]==false && Bank[1]==false && Bank[2]==true && Bank[3]==true) ) {
         num = 13;
		}
		//The goat ate the cabbage, end of the game
		else if ((Bank[0]==true && Bank[1]==false && Bank[2]==false && Bank[3]==true) || (Bank[0]==false && Bank[1]==true && Bank[2]==true && Bank[3]==false) ) {
         num = 12;
        
		}
		//The wolf ate the goat, end of the game
		else if (Bank[0]==true && Bank[1]==false && Bank[2]==false && Bank[3]==false) {
        num = 14;
		}
		//All items transported to north Bank, player won
		 else if (Bank[0]==true && Bank[1] ==true && Bank[2]==true && Bank[3]==true) {
         num = 1;
       
      
      }
		
		//The move was successful
		else {
			num = 0;
		}
		return num;
	}
	
	//row() method to transports the item from one bank to another bank
	
	int row(int choice) {
		int result = 0;
      
		switch(choice) {
		case 1:
			if(Bank[0] == true) {
				Bank[0] = false;
				num = check();
			}
			else {
				Bank[0] = true;
				num = check();
			}
		break;
		
		case 2://to transport cabbage  
			if ( Bank[0] == true && Bank[1] == true) {
               Bank[0] = false;
               Bank[1] = false;
               num = check();
            }
			
			else if(Bank[0] == false && Bank[1] == false)  {
               Bank[0] = true;
               Bank[1] = true;
				   num=check();
			}
         else if ( Bank[0] == true && Bank[1] == false)
            {
               System.out.println("\n***I don't see the cabbage in the north bank***");
               num = 11; }
         else {
               System.out.println("\n***I don't see the cabbage in the South bank***");
               num = 11;
         }
			break;
		
		case 3://to transport  goat
			if( Bank[0] == true && Bank[2] == true) {
               Bank[0] = false;
               Bank[2] = false;
               num = check();
            }
            else if ( Bank[0] == true && Bank[2] == false)
            {
               System.out.println("\n***I don't see the goat in the north bank***");
               num = 11;
            }
            else if ( Bank[0] == false && Bank[2] == false) {
               Bank[0] = true;
               Bank[2] = true;
               num=check();
            }
            else
            {
               System.out.println("\n***I don't see the goat in the south bank***");
               num=11;
            }
			break;
			
		case 4://to transport wolf
			if( Bank[0] == true && Bank[3] == true) {
               Bank[0] = false;
               Bank[3] = false;
               num = check();
            }
            else if ( Bank[0] == true && Bank[3] == false)
            {
               System.out.println("\n***I don't see the wolf in the north bank***");
               num  = 11;
            }
            else if ( Bank[0] == false && Bank[3] == false) {
               Bank[0] = true;
               Bank[3] = true;
               num = check();
            }
            else
            {
               System.out.println("\n***I don't see the wolf in the south bank***");
               num = 11 ;
            }
			break;
		case 5:
			result=5;
			break;
		}
		return num;
	}
	
	
	//returns a String with location of item i
	    public static int getItemStatus(String item) // create a method which returns the status of the items
    {      
      for(int i=0;i<northbank.length;i++)
         {
            if (northbank[i] == item) {
               itemstatus = 1;
            } 
         }
         
      for(int i=0;i<southbank.length;i++)
         {
            if (southbank[i] == item) {
               itemstatus = 0;
            } 
         }
      
            
        return itemstatus;
    }
	 // to find the location by locate() method
    public static void locate() 
    {
         northbank[0] = "";
         northbank[1] = "";
         northbank[2] = "";
         northbank[3] = "";
         southbank[0] = "";
         southbank[1] = "";
         southbank[2] = "";
         southbank[3] = "";
         
         if (Bank[0] == true){
               northbank[0] = "boat";
         } 
         else
         {
            southbank[0] = "boat";
         }
         if (Bank[3] == true){
               northbank[3] = "wolf";
         }
         else
         {
            southbank[3] = "wolf";
         }
         if (Bank[2] == true){
               northbank[2] = "goat";
         }
         else
         {
            southbank[2] = "goat";
         }
         if (Bank[1] == true){
               northbank[1] = "cabbage";
         }
         else
         {
            southbank[1] = "cabbage";
         }
    }

	
	//get() method to returns string with list of all items on North Bank
	public String getNorthBank(Boolean[] Bank, String[] item) {
		List<String> itemList_north = new ArrayList<String>();
		//System.out.println("FROM NORTH BANK : " + Arrays.deepToString(Bank));
		for(int i = 0; i < 4; i++) {
			if(Bank[i] == true) {
				itemList_north.add(item[i]);
			}
		}
		return itemList_north.toString();
	} 
	
	//get() method to returns string with list of all items on South Bank
	public String getSouthBank(Boolean[] Bank, String[] item) {
		List<String> itemList_south = new ArrayList<String>();
		//System.out.println("FROM SOUTH BANK: " + Arrays.deepToString(Bank));
		for(int i = 0; i < 4; i++) {
			if(!Bank[i]) {
				itemList_south.add(item[i]);
			}
		}
		return itemList_south.toString();
	}
   
   
   //error method to print error when wrong move taken
   public static void errors(){
   
         if(num == 0) {
				System.out.println("***Your move was successful!!!***");
		
			}

         
         if(num == 1) {
				System.out.println("\nAll items transported to north Bank, player won");
		
			}
         else if(num == 11){
            System.out.println("I don't see the item in the bank");
         }
		
				
			else if(num == 12) {
				System.out.println("\nThe goat ate the cabbage");
				

			}
			else if(num == 13) {
				System.out.println("\nThe wolf ate the goat,  end of the game");
				
				
			}
			else if(num == 14) {
				System.out.println("\nThe goat ate the cabbage and wolf ate the goat, end of the game");
				
			}
			
		
		
		
		
		   }
   
   public static int getErrornum(){
      return num;
   }

   // reset method to reset game
   public static void reset()
   {
      Bank[0] = false;
      Bank[1] = false;
      Bank[2] = false;
      Bank[3] = false;
      num = 0;
      
      itemstatus = 0;
    }


	
	

	
}
