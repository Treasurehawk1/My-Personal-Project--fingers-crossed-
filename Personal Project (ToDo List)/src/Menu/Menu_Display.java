package Menu;

import java.util.Scanner;

import ToDo_List.To_Do_List;

public class Menu_Display {
		
	// my beginning menu to give myself a framework, will need to be updated in the future as this is all command line interface
	
	// ideas to think about:
	// how to change this to a GUI interface, clicking options instead of typing a letter option, displays of images instead of basic buttons
	// in the future, this should be seen as redundant 
	
	public Menu_Display () {
		To_Do_List List = new To_Do_List();
		Scanner scanner = new Scanner(System.in);
		char option = 's';
		while (option != 'q' && option != 'Q') {
			System.out.println("-----------------------------------------");
			System.out.println("What do you want to do in the todo list?");
			System.out.println("View the to do list now, type v");
			System.out.println("Add to the todo list, type a"); // needs to ask for information to display the information in order, based on date, maybe time in the future
			System.out.println("Update an task on the todo list, type u"); // low priority
			System.out.println("Delete a task, type d");
			System.out.println("Exit out of the program, type q"); // when quitting out, make sure to save the list in a document to not lose data
			System.out.print("Type option here: ");
			option = scanner.next().charAt(0);
			switch (option) {
				case 'v':
				case 'V':
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					//System.out.println(List.tasks);
					System.out.println("Stub for View");// add in a bit
				break;
				case 'a':
				case 'A': 
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					List.Add();
					System.out.println("Stub for Add");// add in a bit
				break;
				case 'u':
				case 'U': 
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					System.out.println("Stub for Update");// add in a bit
				break;
				case 'd':
				case 'D': 
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					System.out.println("Stub for Delete");// add in a bit
				break;
				case 'q':
				case 'Q': 
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					System.out.println("Stub for Quit");// add in a bit
				break;
				default: 
					System.out.print("\033[H\033[2J");  
					System.out.flush();
					System.out.println("Invalid option, try again");
				
				
			}	
		}
	}
	
	
}
