package validate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static customer.Customer.sdf;

import customer.Customer;
import enum_cust.Service_Plan;
import exception.Exception_Handling;

public class Validate  {
	private static int min;
	private static int max;
	private static Date dob_static;
	static {
		min=4;
		max=10;
		try{
			dob_static=sdf.parse("01-01-1995");
		}
		catch( ParseException p) {
			System.out.println("Error in your date format");
			p.setStackTrace(null);
		}
	}
	public static String Check_email(String email,ArrayList<Customer> Customer_List)throws Exception_Handling{
		Customer new_Customer = new Customer(email);
		if(Customer_List.contains(new_Customer)) {
			throw new Exception_Handling("Your Details are already existed");
		}
		return email;
	}
	public static String Validate_email_Name(String email)throws Exception_Handling{
			if(email.contains("@")) {
				if(email.endsWith(".com")||email.endsWith(".org")) {
			return email;
				}
				throw new Exception_Handling("Not included .com or .org");
			}
			throw new Exception_Handling("Not included @");
			}
//	public static String Validate_email(String email,ArrayList<Customer> Customer_List)throws Exception_Handling{
//		String regex="(?=.[@])"+"(?=\\S+$).[.com]"
//	}
	public static String Validate_Password(String Password)throws Exception_Handling {
		String regex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#%^&])(?=\\S+$).{4,10}$";
		if(Pattern.compile(regex).matcher(Password).matches())
			return Password;
		throw new Exception_Handling("Invalid Password Please add AlphaNumeric and one Special Character");
		}
	public static Date Validate_DOB(String dob) throws ParseException, Exception_Handling{
		Date Given_Date=sdf.parse(dob);
		if(Given_Date.before(dob_static)) {
			return Given_Date;
		}
		throw new Exception_Handling("Invalid date of Birth");
	}
	public static Service_Plan Validate_Service_Plan(String s_p)throws Exception_Handling {
		try {
		     return Service_Plan.valueOf(s_p.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			e.getStackTrace();
			StringBuilder sb=new StringBuilder("Available Service Plans are ");
			sb.append(Arrays.toString(Service_Plan.values())+"\n");
			sb.append("Choose correct service plan");
			throw new Exception_Handling(sb.toString());
		}
	}
	public static String Password_Check(String Password,ArrayList<Customer> Customer_List,String email)throws Exception_Handling {
		if(Customer_List.equals(Password)) {
			return "Success";
		}
		throw new Exception_Handling("Your password is not matched");
	}
	}