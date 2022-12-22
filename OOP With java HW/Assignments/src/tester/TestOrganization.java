package tester;

import java.util.Scanner;

import com.app.org.Emp;
import com.app.org.Mgr;
import com.app.org.Worker;
public class TestOrganization {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter size of array");
			Emp[] arr=new Emp[sc.nextInt()];
			int option;
			int index=0;
			do {
			System.out.println("Enter option 1.Hire Manager 2.Hire Worker 3.Display all employees 4.Update basic sal 10.Exit");
			option=sc.nextInt();
			switch(option) {
			case 1:
				if(index<arr.length) {
				Emp obj=new Mgr(sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextDouble());
				arr[index]=obj;
				index++;
				}
				break;
			case 2:
				if(index<arr.length) {
				Emp obj=new Worker(sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt(),sc.nextInt());
				arr[index]=obj;
				index++;
				}
				break;
			case 3:
//				for(int i=0;i<arr.length;i++) {
//					if(i<=index) {
//						if(arr[i] instanceof Mgr) {
//							System.out.println(((Mgr)arr[i]).net_sal());
//							System.out.println(((Mgr)arr[i]).toString());
//							continue;
//					}
//						else if(arr[i] instanceof Worker) {
//							System.out.println(((Worker)arr[i]).net_sal());
//							System.out.println(((Worker)arr[i]).toString());
//						}
//				}
//				}
				for(Emp e:arr) {
					if(e!=null) {
					if(e instanceof Mgr) {
						System.out.println(((Mgr)e).net_sal());
						System.out.println(((Mgr)e).toString());
						continue;
				}
					else if(e instanceof Worker) {
						System.out.println(((Worker)e).net_sal());
						System.out.println(((Worker)e).toString());
					}
					}
				}
				break;
			case 4:
				System.out.println("Enter employee id and salary increment");
				int specific_index=sc.nextInt();
				double amount=sc.nextDouble();
				OutOfBound Obj=new OutOfBound();
				try{
					Obj.OutOfBound(specific_index, index);
					arr[specific_index].setBasic(amount);	
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			}while(option!=10);
		}
	}
}