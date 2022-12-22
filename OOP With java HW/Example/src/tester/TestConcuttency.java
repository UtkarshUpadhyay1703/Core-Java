package tester;

import java.util.Scanner;

import runnable_tasks.EvenPrinterTask;
import runnable_tasks.OddPrinterTask;

public class TestConcuttency {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter range");
			int start=sc.nextInt();
			int end=sc.nextInt();
			Thread t1=new Thread(new EvenPrinterTask(start, end));
			Thread t2=new Thread(new OddPrinterTask(start, end));
			t1.start();
			t2.start();
			System.out.println("main waiting for chile thrds to fiish exec");
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
