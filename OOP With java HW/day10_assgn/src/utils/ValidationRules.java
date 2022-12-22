package utils;

import static com.app.core.Customer.sdf;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.security.auth.kerberos.ServicePermission;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class ValidationRules {
	// add static date
	public static Date checkDate;
	public Date beginDate;
	public Date afterDate;
	static {
		try {
			checkDate=sdf.parse("1/1/1995");
		} catch (ParseException e) {
			System.out.println("err in static init block "+e);
		}
	}

//add a static method for email validation
	public static String validateEmail(String email) throws CustomerHandlingException {
		String pattern = "^[\\w\\.-]+@[\\w\\.-]+(com|org|net)$";
		if (email.matches(pattern))
			return email;
		throw new CustomerHandlingException("Invalid Email !!!!!!!!!!!!!");
	}
//public static void Unsubscribe(String email,List<Customer> list) {
//	Customer C=new Customer(email);
//	for(Customer c: list)
//		if(c.getEmail().equals(email))
//			list.remove(c);
//}
	public static void Unsubscribe(String email,String password, List<Customer> list) throws CustomerHandlingException {
		validateEmail(email);
		validatePassword(password);
		Customer C=new Customer(email);
		for(Customer c:list)
			if(c.getEmail().equals(email))
				if(c.getPassword().equals(password))
				list.remove(c);
	}
	public static Customer findByEmail(String email,List<Customer> list) throws CustomerHandlingException {
		Customer c=new Customer(email);
		int index=list.indexOf(c);
		if(index==-1) {
			throw new CustomerHandlingException("Invalid id");
		}
		
		return list.get(index);
	}
	// add a static method for pwd validation
	public static String validatePassword(String pwd) throws CustomerHandlingException {
		String pattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{5,10}";
		if (pwd.matches(pattern))
			return pwd;
		throw new CustomerHandlingException("Invalid Password!!!!!");
	}

	// add a static method to parse n validate date
	public static Date parseAndValidateDob(String dob) throws ParseException,CustomerHandlingException {
		Date dobDate = sdf.parse(dob);
		if(dobDate.before(checkDate))
			return dobDate;
		throw new CustomerHandlingException("Invalid DoB!!!!!!!!!!!!");

	}
	// add a static method to check if email id is dup
	public static String checkForDup(String email,List<Customer> custList) throws CustomerHandlingException
	{
		//em : abc101@gmail.com
		//1. create customer instance to wrap PK(email)
		Customer c=new Customer(email);
		//{c1(abc1@gmail.com),c2,.....c100}
		if(custList.contains(c)) //contains internally invokes Customer's equals method 
			throw new CustomerHandlingException("Dup email !!!!!!!!!!!!!!");
		return email;
	}
	//add a static method to invok all validates rules: this method will be invoked by the tester
	public static Customer validateCustomerDetails(String name,String email,String pwd,double regAmounnt,String dob,String plan,List<Customer>list) throws CustomerHandlingException,ParseException{
		checkForDup(validateEmail(email),list);
		validatePassword(pwd);
		Date d1=parseAndValidateDob(dob);
		ServicePlan serviceplan = ServicePlan.valueOf(plan.toUpperCase());
		return new Customer(name, email, pwd, regAmounnt, d1, serviceplan);	
	}
//	public void beforeAfter(String beginDate,String afterDate) throws ParseException {
//		try{this.beginDate=sdf.parse(beginDate);
//		this.afterDate=sdf.parse(afterDate);
//		}
//		catch(ParseException p) {
//			p.printStackTrace();
//		}
//	}
	public static void beforeAfter(String beginDate,String afterDate,List<Customer> list) throws ParseException, CustomerHandlingException {
		Date beginDate1 = parseAndValidateDob(beginDate);
		Date afterDate1 = parseAndValidateDob(afterDate);
		for(Customer c:list)
			if(c.getDate().before(afterDate1)&& c.getDate().after(beginDate1))
				System.out.println(c);
		throw new CustomerHandlingException("Invalid DoB!!!!!!!!!!!!");

	}
	public static void detailsViaPlan(String serviceplan,List<Customer> list) throws CustomerHandlingException {
		ServicePlan serviceplan1=com.app.core.ServicePlan.valueOf(serviceplan.toUpperCase());
		Boolean flag=true;
		for(Customer c:list) {
			if(c.getServicePlan().equals(serviceplan1)) {
				System.out.println(c);
				flag=false;
			}
		}
		if(flag)
		throw new CustomerHandlingException("No one matched");
	}
}