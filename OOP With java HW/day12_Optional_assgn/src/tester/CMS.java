package tester;

import static utils.CMSUtils.ValidateLogin;
import static utils.CMSUtils.populateCustomerDetails;
import static utils.ValidationRules.Unsubscribe;
import static utils.ValidationRules.beforeAfter;
import static utils.ValidationRules.detailsViaPlan;
import static utils.ValidationRules.validateCustomerDetails;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;

import custom_exceptions.CustomerHandlingException;

public class CMS {

	public static void main(String[] args) throws CustomerHandlingException,ParseException {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase
			// get a populated AL<Customer> from CMSUtils
			List<Customer> customerList = populateCustomerDetails();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1.Register a Customer, 2. Display all registered customer, "
						+ "3. Customer login, 4. Change Password , 5. Un subscribe customer,\n"
						+ "6. Display names of the customers born between 2 specified dates.\n"
						+ "7. Display all the customer details ,who have chosen specific plan");
				try {
					System.out.println("");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer details for Signup:String name, String email,"
								+ " String password, int regAmount, String dob, String plan");
						Customer cust=validateCustomerDetails(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(), customerList);
						customerList.add(cust);
						break;
					case 2:
						System.out.println("Customer Details");
						for(Customer c: customerList)
							System.out.println(c);
						break;
					case 3:
						System.out.println("Enter email id and Password");
						cust=ValidateLogin(sc.next(),sc.next(),customerList);
						System.out.println("Successful login Your details:"+cust);
						break;
					case 4:
						System.out.println("Enter email id Old Password ");
						cust=ValidateLogin(sc.next(),sc.next(),customerList);
						System.out.println("Successful login  \n  Enter new Password");
						cust.setPassword(sc.next());
						System.out.println("Successful Password updated");
						break;
					case 5:
						System.out.println("Enter email and password to unsubscribe");
						Unsubscribe(sc.next(),sc.next(),customerList);
						System.out.println("Successfully unsubscribe");
						break;
					case 6:
						System.out.println("Enter Begin date and end date but should earlier then 01/01/1995 ");
						beforeAfter(sc.next(),sc.next(),customerList);
						break;
					case 7:
						System.out.println("Service plan");
						detailsViaPlan(sc.next(),customerList);
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}
		} // JVM : sc.close()

	}

}
