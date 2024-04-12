package ToDo_List;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_List {
	
	private static ArrayList<String> tasks = new ArrayList<String>();
	static ArrayList<String> dates = new ArrayList<String>();
	//static ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
	
	public static ArrayList<String> getTasks() {
		return tasks;
	}

	public static void setTasks(ArrayList<String> tasks) {
		To_Do_List.tasks = tasks;
	}

	public void Add() {
		char option = 'p'; // p for placeholder
		String task = "";
		String date = "";
		String month;
		String day;
		String hour;
		String minute; 
		String amPm = "";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Please type the task you would like to add!");
			task = scanner.next();
			//scanner.nextLine();
			if (task.isEmpty()) {
				System.out.println("Please enter a task, or type c to cancel!");
				option = scanner.next().charAt(0);
			}
			else {
				System.out.println("What time and date would you like it set on to be completed?");
				System.out.print("Enter month!");
				month = scanner.nextLine();
				System.out.print("Enter the day of the month!");
				day = scanner.nextLine();
				System.out.print("Enter the hour!");
				hour = scanner.nextLine();
				System.out.print("Enter enter the minute!");
				minute = scanner.nextLine();
				System.out.print(" Enter AM or PM");
				amPm = scanner.nextLine();
				amPm.toLowerCase();
				if (amPm == "pm") {
					hour = hour + 11;
				}
			}
			//scanner.nextLine();
		} while (task.isEmpty() && option != 'c' && option != 'C');
		tasks.add(task);
	}
	
}
