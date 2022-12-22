package tester;

import static reader.Reader.dateMaxWithdraw;
import static reader.Reader.maxDeposite;
import static reader.Reader.shoppingExpenses;
import static reader.Reader.sumDeposits;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws IOException {
		try(Scanner sc = new Scanner(System.in);)  {
			int option;
			boolean exit=false;
			do {
				System.out
						.println("Enter option Display following details on the console:\n" + "A.Sum of all deposits\n"
								+ "B.Max deposit amount\n C.Shopping expenses (sum of withdrawals for shopping)\n"
								+ "D.Date on which maximum amount withdrawn, E. For Exit");
			

//				System.out.println(option);
				switch (option=sc.nextInt()) {
				case 1:
					sumDeposits();
					break;
				case 2:
					maxDeposite();
					break;
				case 3:
					shoppingExpenses();
					break;
				case 4:
					dateMaxWithdraw();
					break;
				case 5:
					exit=true;
					break;
				}
			} while (!exit);
			System.out.println("End of While");
			}catch (NoSuchElementException e) {
			e.printStackTrace();
//			sc.nextLine();
			
		}
	}
}
