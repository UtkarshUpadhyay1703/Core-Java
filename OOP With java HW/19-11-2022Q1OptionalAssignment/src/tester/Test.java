package tester;

import java.io.File;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("Enter file path");
		try(Scanner sc=new Scanner(System.in);
				Scanner sc2=new Scanner(new File(sc.nextLine()));){
			String str=sc2.nextLine();
			Double sumDeposits=0.0;
			Double maxAmount=0.0;
			Double sumShopping=0.0;
			Double maxWid=0.0;
			String datemax=null;
			String[] arr;
			while(sc2.hasNextLine() && str==sc2.nextLine()) {
				arr=str.split(",");
				if(sumDeposits<Double.parseDouble(arr[3])) sumDeposits=sumDeposits+Double.parseDouble(arr[3]);
				if(maxAmount<Double.parseDouble(arr[3])) maxAmount=Double.parseDouble(arr[3]);
				if(arr[1].equals("Shopping")) sumShopping=sumShopping+Double.parseDouble(arr[2]);
				if(maxWid<Double.parseDouble(arr[2])) {
					maxWid=Double.parseDouble(arr[2]);
					datemax=arr[0];
				}
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
