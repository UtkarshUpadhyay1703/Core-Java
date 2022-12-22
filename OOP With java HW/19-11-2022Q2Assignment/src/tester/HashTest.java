package tester;

import static validation.Validation.checkId;
import static validation.Validation.checkStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import enums.STATUS;
import taskmanager.TaskManager;

//import static validation.HashValidation.populateHash;
//
//import java.time.LocalDate;
//import java.util.Map;
//import java.util.Scanner;
//
//import taskmanager.TaskManager;

public class HashTest {

	public static void main(String[] args) {
//		Map<Integer, TaskManager> map=populateHash();
//		try(Scanner sc=new Scanner(System.in)){
//			int option;
//			do {
//			System.out.println("Enter the option 1. Add New Task\r\n"
//					+ "2. Delete a task\r\n"
//					+ "3. Update task status\r\n"
//					+ "4. Display all pending tasks\r\n"
//					+ "5. Display all pending tasks for today\r\n"
//					+ "6. Display all tasks sorted by taskDate\r\n");
//			option=sc.nextInt();
//			switch(option) {
//			case 1:
//				map.put(0, new TaskManager(sc.next(), sc.next(), LocalDate.parse(sc.next())));
////				map.forEach((k,v) -> System.out.println(k+"   "+v));
//				break;
//			case 2:
//				System.out.println("Enter id");
//				break;
//			case 3:
//				map.forEach((k, v) -> System.out.println(k + "   " + v));
//				for(TaskManager tm:map.values())System.out.println(tm);
//				break;
//			}
//				
//			
//		}while(option!=10);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		ArrayList<TaskManager> tm=new ArrayList<>();
		try(Scanner sc=new Scanner(System.in)){
			int option;
			do {
				option=sc.nextInt();
				switch(option) {
				case 1:
					tm.add(new TaskManager(sc.next(), sc.next(), LocalDate.parse(sc.next())));
					break;
				case 2:
					System.out.println("Enter id");
					int id= checkId(sc.nextInt(),tm);
					tm.get(id-1).setActive(false);
					break;
				case 3:
					System.out.println("Enter id");
				    id= checkId(sc.nextInt(),tm);
					tm.get(id-1).setStatus(checkStatus(sc.next()));
					break;
				case 4:
//					tm.stream()
//					.filter(t -> t.getStatus()==STATUS.PENDING).
					for(TaskManager k:tm) {
						if(k.getStatus()==STATUS.PENDING)
						System.out.println(k);
					}
					break;
				case 5:
					for(TaskManager k:tm) {
						if(k.getStatus()==STATUS.PENDING && k.getTaskDate()==LocalDate.now())
							System.out.println(k);
					}
					break;
				case 6:
					Collections.sort(tm, new Comparator<TaskManager>() {
						@Override
						public int compare(TaskManager T1,TaskManager T2) {
							return T1.getTaskDate().compareTo(T2.getTaskDate());
						}
				});
					break;
				}
				
			}while(option!=10);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
