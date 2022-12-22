package tester;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;

import pojo.Bank;
//LocalDate.parse((arr[0]),DateTimeFormatter.ofPattern("dd-MM-YYYY")

public class Test {

	public static void main(String[] args) {
		ArrayList<Bank> list=new ArrayList<>();
		System.out.println("Enter path");
		System.out.println("Enter Destination path");
		try(Scanner sc=new Scanner(System.in);
				Scanner sc2=new Scanner(new File(sc.nextLine()));
				PrintWriter pw=new PrintWriter(new FileWriter(sc.nextLine(),true));){
			String str=sc2.nextLine();
			String[] arr=null;
			while((sc2.hasNext())&& (str=sc2.nextLine())!=null) {
				arr=str.split(",");
				list.add(new Bank(LocalDate.parse((arr[0]),DateTimeFormatter.ofPattern("dd-MM-yyyy")),
						arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3])));
				pw.println(str);
			}
			for(Bank k:list)System.out.println(k);
			int option;
			do {
				System.out.println("1.Sum of all deposits\r\n"
						+ "2.Max deposit amount\r\n"
						+ "3.Shopping expenses (sum of withdrawals for shopping)\r\n"
						+ "4.Date on which maximum amount withdrawn");
			option=sc.nextInt();
				switch (option) {
			case 1:
			Double sumDeposite=list.stream()
			.mapToDouble(t -> t.getDepositeAmount())
			.sum();
			System.out.println(sumDeposite);
			break;
			case 2:
				OptionalDouble maxDeposite=list.stream()
				.mapToDouble(t -> t.getDepositeAmount())
				.max();
				System.out.println(maxDeposite);
				break;
			case 3:
				double sumWith=list.stream()
				.filter(t->t.getNarration().equals("Shopping"))
				.mapToDouble(t->t.getWithdrawlAmount())
				.sum();
				System.out.println(sumWith);
				break;
			case 4:
				double maxWith=list.stream()
				.mapToDouble(t->t.getWithdrawlAmount())
				.max().getAsDouble();
				list.stream()
						.filter(t->t.getWithdrawlAmount()==maxWith)
						.map(t->t.getTransactionDate())
						.forEach(s->System.out.println(s));
				break;
			}
			}while(option!=10);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
