package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
	public static void sumDeposits() throws FileNotFoundException, IOException {
		System.out.println("Enter the path");
		try (Scanner sc = new Scanner(System.in); 
				Scanner scFile = new Scanner(new File(sc.nextLine()));) {
			String str = scFile.nextLine();
			String[] arr = null;
			Double sumDeposite = 0.0;
			while (((scFile.hasNextLine())) && (str = scFile.nextLine()) != null) {
				arr = str.split(",");
				sumDeposite = sumDeposite + Double.parseDouble(arr[3]);
			}
			System.out.println("Sum of all deposits" + sumDeposite);

		}
	}

	public static void maxDeposite() throws FileNotFoundException {
		System.out.println("Enter the path");
		try (Scanner sc = new Scanner(System.in); Scanner scFile = new Scanner(new File(sc.nextLine()));) {
			String str = scFile.nextLine();
			String[] arr = null;
			Double depositeAmount = 0.0;
			while (((scFile.hasNextLine())) && (str = scFile.nextLine()) != null) {
				arr = str.split(",");
				if (depositeAmount < Double.parseDouble(arr[3])) {
					depositeAmount = Double.parseDouble(arr[3]);
				}
			}
			System.out.println("Max deposit amount = " + depositeAmount);
		}
	}

	public static void shoppingExpenses() throws FileNotFoundException {
		System.out.println("Enter the path");
		try (Scanner sc = new Scanner(System.in); Scanner scFile = new Scanner(new File(sc.nextLine()));) {
			String str = scFile.nextLine();
			String[] arr = null;
			Double expensesShoping = 0.0;
			while (((scFile.hasNextLine())) && (str = scFile.nextLine()) != null) {
				arr = str.split(",");
				if (arr[1].equals("Shopping")) {
					expensesShoping = expensesShoping + Double.parseDouble(arr[2]);
				}
			}
			System.out.println("Shopping expenses (sum of withdrawals for shopping) = " + expensesShoping);
		}
	}

	public static void dateMaxWithdraw() throws FileNotFoundException {
		System.out.println("Enter the path");
		try (Scanner sc = new Scanner(System.in); Scanner scFile = new Scanner(new File(sc.nextLine()));) {
			String str = scFile.nextLine();
			String[] arr = null;
			Double dateMax = 0.0;
			String dateofmax = null;
			while (((scFile.hasNextLine())) && (str = scFile.nextLine()) != null) {
				arr = str.split(",");
				if (dateMax < Double.parseDouble(arr[2])) {
					dateMax = Double.parseDouble(arr[2]);
					dateofmax = arr[0];
				}
			}
			System.out.println("Date on which maximum amount withdrawn = " + dateofmax);
		}
	}
}