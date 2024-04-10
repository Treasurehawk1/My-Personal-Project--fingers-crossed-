package ToDo_List;

import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_List {
	
	static ArrayList<String> tasks = new ArrayList<String>();
	
	
	public static ArrayList<String> getTasks() {
		return tasks;
	}


	public static void setTasks(ArrayList<String> tasks) {
		To_Do_List.tasks = tasks;
	}


	public void Add() {
		
		String task = "";
		
		System.out.println("Please type the task you would like to add!");
		Scanner scanner = new Scanner(System.in);
		task = scanner.nextLine();
		System.out.println(task);
		tasks.add(task);
		
	}
	
}
