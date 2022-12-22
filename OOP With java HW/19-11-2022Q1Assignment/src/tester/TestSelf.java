package tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestSelf {
	@Override
	public boolean equals(Object anotherObject) {
		return this.equals(anotherObject);
	}

	public static void main(String[] args) {
		System.out.println("Enter the path");

		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));) {
			String str=br.readLine();
			String[] arr = null;
			double sumDeposite=0.0; 
			double depositeAmount=0.0;
			double expensesShoping=0.0;
			double dateMax=0.0;
			String dateofmax=null;
			while ((str = br.readLine()) != null) {
				arr = str.split(",");
				sumDeposite=sumDeposite+Double.parseDouble(arr[3]);
				if(depositeAmount<Double.parseDouble(arr[3])) {
					depositeAmount=Double.parseDouble(arr[3]);
					
				}
				if(arr[1].equals("Shopping")) {
					expensesShoping=expensesShoping+Double.parseDouble(arr[2]);
				}
				if(dateMax<Double.parseDouble(arr[2])) {
	//				dateofmax=LocalDate.parse(arr[0], DateTimeFormatter.ofPattern("dd-MM-YYYY"));
					dateMax=Double.parseDouble(arr[2]);
					dateofmax=arr[0];
				}
				
			}
			System.out.println("Sum= "+sumDeposite);
			System.out.println("depositeAmount"+depositeAmount);
			System.out.println("expensesShoping"+expensesShoping);
			System.out.println("dateofmax"+dateofmax);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		try (Scanner sc = new Scanner(System.in); Scanner scFile = new Scanner(new File(sc.nextLine()));) {
//			String str = scFile.nextLine();
//			String[] arr = null;
//			Double sumDeposite = 0.0;
//			Double depositeAmount = 0.0;
//			Double expensesShoping = 0.0;
//			Double dateMax = 0.0;
//			String dateofmax = null;
//			while (((scFile.hasNextLine())) && (str = scFile.nextLine()) != null) {
//				arr = str.split(",");
//				sumDeposite = sumDeposite + Double.parseDouble(arr[3]);
//				if (depositeAmount < Double.parseDouble(arr[3])) {
//					depositeAmount = Double.parseDouble(arr[3]);
//
//				}
//				if (arr[1].equals("Shopping")) {
//					expensesShoping = expensesShoping + Double.parseDouble(arr[2]);
//				}
//				if (dateMax < Double.parseDouble(arr[2])) {
//					dateMax = Double.parseDouble(arr[2]);
//					dateofmax = arr[0];
//				}
//			}
//			System.out.println("Sum= " + sumDeposite);
//			System.out.println("depositeAmount= " + depositeAmount);
//			System.out.println("expensesShoping= " + expensesShoping);
//			System.out.println("dateofmax= " + dateofmax);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
