/*
Name: Sudip khatri 
Student ID: s4613222


RiverGUI class creates the panel with all necessary components.
It also assigns the action event to buttons.
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CommandLineInterface {

	public static void main(String[] args) {
		
		//Variables
		int choice = 0;
		
		RiverCrossing river = new RiverCrossing(); //get methods from RiverCrossing.
		Boolean[] Bank = river.getBool();
		String[] item = river.getitem();
		//System.out.println("Bank Boolean " + Arrays.toString(Bank));
		//System.out.println("Item list: " + Arrays.deepToString(item));
		
		System.out.println("\n\t\tWelcome to the CLI version of the River Crossing Game.\n"+
						   "\t\tFarmer crossing a river has boat, cabbage, goat and wolf.\n"+
						   "\t\tBoat can carry two items at a time and cannot leave\n" + 
						   "\t\tthe cabbage alone with the goat or the goat with the wolf.\n\n");
		
		int i = 0;
		int final_statement = 0;
		while(choice!=5) {
			
			System.out.printf("North Bank: " + river.getNorthBank(Bank, item));
			System.out.println("\n--------------------------------------------------------------------------\n" + 
							   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
							   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
							   "----------------------------------------------------------------------------");
			System.out.printf("South Bank: " + river.getSouthBank(Bank, item));
			
			System.out.println("\n\nYou have the following choices: \n" +
							   "1. Row across by yourself\n" + 
							   "2. Take the cabbage with you\n" + 
							   "3. Take the goat with you\n" + 
							   "4. Take the wolf with you\n" +
							   "5. Quit\n" + 
							   "\nWhat is your choice (1, 2, 3, 4 or 5)?: ");
			
			//scans users choice
         Scanner user_choice = new Scanner(System.in);
			choice = user_choice.nextInt();
			int final_result = river.row(choice);
			
			System.out.printf("North Bank: " + river.getNorthBank(Bank, item));
			System.out.println("\n--------------------------------------------------------------------\n" + 
							   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
							   "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
						        "----------------------------------------------------------------------");
			
			System.out.printf("South Bank: " + river.getSouthBank(Bank, item));
			if(final_result == 0) {
				System.out.println("\n\nMove was Successful\n");
			}
         
         else if(final_result == 11) {
            System.out.println("\n ***I don't see the item in the bank***");
         }
			else if(final_result == 1) {
				System.out.println("\nAll items transported to north Bank, player won");
				choice = 5;
				final_statement = 100;
			}
			else if(final_result == 15) {
				System.out.println("\nI don't see the wolf on the North Bank");
				choice = 5;
				final_statement = 99;
			}
			else if(final_result == 12) {
				System.out.println("\nThe goat ate the cabbage");
				choice = 5;
				final_statement = 99;
			}
			else if(final_result == 13) {
				System.out.println("\nThe wolf ate the goat,  end of the game");
				choice = 5;
				final_statement = 99;
			}
			else {
				System.out.println("\nThe goat ate the cabbage and wolf ate the goat, end of the game");
				choice = 5;
				final_statement = 99;
			}
			
		}
      //messages for loss, quit and win
		if(choice == 5 && final_statement != 99) {
			System.out.println("\nYou decided to quit...exiting!!!!!");
		}
		
		if(final_statement == 99) {
			System.out.println("You lose the game....");
		}
		
		if(final_statement == 100) {
			System.out.println("Congratulations...You Won!!!! ");
		}
			
		
	}

}
