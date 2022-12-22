package tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static validate.Validate.Check_email;
import static validate.Validate.Validate_Password;
import static validate.Validate.Validate_email_Name;
import static validate.Validate.Validate_DOB;
import static validate.Validate.Validate_Service_Plan;
import static validate.Validate.Password_Check;

import customer.Customer;
import enum_cust.Service_Plan;

public class Test1 {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			int option;
		List<Customer> Customer_List=new ArrayList<>();
		do {
		System.out.println("Enter the options 1.Customer Registration "
				+ "\n 2.Display Details of all registered customer");
		option=sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("Enter Customer details");
			System.out.println("String email,String name, String password, Double RegAmount, Date DOB,Service_Plan service_plan");
			Customer C1 = new Customer(Check_email(Validate_email_Name(sc.next()),Customer_List),sc.next(),Validate_Password(sc.next()),sc.nextDouble(),Validate_DOB(sc.next()),Validate_Service_Plan(sc.next()));
			Customer_List.add(C1);
			break;
		case 2:
			for(Customer Details:Customer_List) {
				System.out.println(Details);
			}
//			for(int i=0;i<Customer_List.size();i++) {
//				System.out.println(Customer_List.get(i));
//			}
			break;
		case 3:
			System.out.println("Enter Email for login");
			String EmailCopy=(Check_email(Validate_email_Name(sc.next()),Customer_List));
			System.out.println("Enter password for login");
			String msg=Password_Check(sc.next(),Customer_List,EmailCopy);
			System.out.println(msg);
			break;
		case 4:
			System.out.println("Enter Email for login");
			EmailCopy=(Check_email(Validate_email_Name(sc.next()),Customer_List));
			System.out.println("Enter old password for login");
			Password_Check(sc.next(),Customer_List,EmailCopy);
			System.out.println("Enter new password");
			//setPassword(Validate_email_Name(sc.next()));
		}
	}while(option!=10);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}