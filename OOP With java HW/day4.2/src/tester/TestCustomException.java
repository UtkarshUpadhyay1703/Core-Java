package tester;

import java.util.Scanner;

import custom_exception.SpeedOutOfBoundsException;

import static utils.SpeedValidation.validateSpeed;

public class TestCustomException {

	public static void main(String[] args) /* throws SpeedOutOfBoundsException */ {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter curnt speed");
			validateSpeed(sc.nextInt());
			System.out.println("End of try...");
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			System.out.println("LOL"+e.getMessage());
			System.out.println("LOL"+e.getMessage());
		}
		System.out.println("code continues...");

	}

}
