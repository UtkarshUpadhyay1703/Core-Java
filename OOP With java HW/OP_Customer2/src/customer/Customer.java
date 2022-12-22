package customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import enum_cust.Service_Plan;

public class Customer {
	private String email;
	private int id;
	private String name;
	private String password;
	private Double RegAmount;
	private Date DOB;
	private Service_Plan service_plan;
	private static int counter;
	public static SimpleDateFormat sdf;
	static {
		counter = 1;
		sdf = new SimpleDateFormat("d-M-y");
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	public Customer(String email, String name, String password, Double RegAmount, Date DOB, Service_Plan service_plan) {
		super();
		this.email = email;
		this.id = counter;
		this.name = name;
		this.password = password;
		this.RegAmount = RegAmount;
		this.DOB = DOB;
		this.service_plan = service_plan;
		counter++;
	}

	public String toString() {
		return "email" + email + "id" + id + "name" + name + "pass" + password + "Reg" + RegAmount + "Date" + DOB + "SP"
				+ service_plan;
	}

	public void setPassword(String password) {
		this.password = password;
	}
@Override
	public boolean equals(Object anotherCustomer) {
		if (anotherCustomer instanceof Customer) {
			return this.email.equals(((Customer) anotherCustomer).email);
		}
		return false;
	}
}
