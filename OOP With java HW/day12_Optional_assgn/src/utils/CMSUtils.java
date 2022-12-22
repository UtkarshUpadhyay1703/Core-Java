package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import static utils.ValidationRules.validateCustomerDetails;
import static utils.ValidationRules.validateEmail;
import static utils.ValidationRules.validatePassword;
import static utils.ValidationRules.findByEmail;
import com.app.core.*;

import custom_exceptions.CustomerHandlingException;

public class CMSUtils {
	public static List<Customer> populateCustomerDetails() throws ParseException, CustomerHandlingException {
		List<Customer> list = new ArrayList<>();
		list.add(validateCustomerDetails("RAM", "ram123@.com", "a@Ak12", 50000, "14/05/1994", "gold", list));
		list.add(validateCustomerDetails("Chetan", "Chetan123@.com", "c@Ak12", 15000, "10/05/1994", "Silver", list));
		list.add(validateCustomerDetails("Riya", "Riya123@.com", "r@Ak12", 17000, "11/06/1994", "Diamond", list));
		list.add(validateCustomerDetails("RA", "ram23@.com", "a@A12", 50000, "14/05/1994", "gold", list));
		return list;
	}

	public static Customer ValidateLogin(String email, String Password, List<Customer> list)
			throws CustomerHandlingException {
		validateEmail(email);
		validatePassword(Password);
		Customer c = findByEmail(email, list);
		if (c.getPassword().equals(Password))
		return c;
		throw new CustomerHandlingException("Not login please try again");
	}
}
