package utils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.app.core.CustomException;
import com.app.core.Customer;

import static com.app.core.Customer.sdf;

public class ValidateRules {
	private static int min;
	private static int max;
	private static Date dob_static;
	static {
		try {
			dob_static = sdf.parse("01-01-1995");
		} catch (ParseException p) {
			System.out.println("Error in your date format");
			p.setStackTrace(null);
		}
	}

	public static String validateEmail(String email) throws CustomException {
		String pattern = "^[\\w\\.-]+@[\\w\\.-]+(com|org|net)$";
		if (email.matches(pattern))
			return email;
		throw new CustomException("Invalid Email");
	}

	public static String Validate_Password(String pwd) throws CustomException {
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$#%^&])(?=\\S+$).{4,10}$";
		if (pwd.matches(pattern))
			return pwd;
		throw new CustomException("Invalid Password Please add AlphaNumeric and one Special Character");
	}

	public static Date parseAndValidateDob(String dob) throws ParseException, CustomException {
		Date Given_Date = sdf.parse(dob);
		if (Given_Date.before(dob_static)) {
			return Given_Date;
		}
		throw new CustomException("Invalid date of Birth");
	}
	public static String checkForDuplicate(String email,List<Customer>custList) throws CustomException{
		Customer newCustomer=new Customer(email);
		if(custList.contains(newCustomer))
			throw new CustomException("Duplicate email id");
		return email;
	}
}