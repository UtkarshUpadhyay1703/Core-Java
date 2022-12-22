package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import custom.ExceptionHandler;
import enums.STATUS;

import static validation.Validation.*;

import taskmanager.TaskManager;

public class Test {

	public static void main(String[] args) throws ExceptionHandler {
		ArrayList<TaskManager> list = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in)) {
			char option;
			do {
				System.out.println("Enter option A) Add New Task\r\n" + "B. Delete a task\r\n"
						+ "C. Update task status\r\n" + "D. Display all pending tasks\r\n"
						+ "E. Display all pending tasks for today\r\n" + "F. Display all tasks sorted by taskDate");
				option = sc.next().charAt(0);
				switch (option) {
				case 'A':
					System.out.println("String taskName, String description, LocalDate taskDate");
					TaskManager tm = new TaskManager(sc.next(), sc.next(), LocalDate.parse(sc.next()));
					list.add(tm);
					System.out.println("Added done");
					for (TaskManager t : list) {
						System.out.println(t);
					}
					break;
				case 'B':
					System.out.println("Enter id");
					int id = checkId(sc.nextInt(), list);
					list.get(id - 1).setActive(false);
					break;
				case 'C':
					System.out.println("Enter status and id");
					updateStatus(sc.next(), sc.nextInt(), list);
					System.out.println("Done");
					break;
				case 'D':
					for (TaskManager t : list) {
						if (t.getStatus() == STATUS.PENDING)
							System.out.println(t);
					}
					break;
				case 'E':
					for (TaskManager t : list) {
						if (t.getStatus() == STATUS.PENDING && t.getTaskDate().compareTo(LocalDate.now()) == 0)
							System.out.println(t);
					}
					break;
				case 'F':
					Collections.sort(list, new Comparator<TaskManager>() {
						@Override
						public int compare(TaskManager t1, TaskManager t2) {
							return t1.getTaskDate().compareTo(t2.getTaskDate());
						}
					});
					for (TaskManager t : list) {
						System.out.println(t);
					}
					break;
				}

			} while (option != 'G');
		}
	}
}
