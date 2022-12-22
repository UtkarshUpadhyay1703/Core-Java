package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Comparable<Customer> {
	private String email;
	private int customerid;
	private String name;
	private String password;
	private Double RegAmount;
	private Date dob;
	private ServicePlan plan;
	private static int idgenerator;
	public static SimpleDateFormat sdf;
	static {
		idgenerator = 1;
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public Customer(String email, String name, String password, Double RegAmount, Date DOB, ServicePlan plan) {
		super();
		this.email = email;
		this.customerid = idgenerator++;
		this.name = name;
		this.password = password;
		this.RegAmount = RegAmount;
		this.dob = dob;
		this.plan = plan;
	}
	public Customer(String email) {
		super();
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [email=" + email + ", customerid=" + customerid + ", name=" + name + ", password=" + password
				+ ", RegAmount=" + RegAmount + ", dob=" + sdf.format(dob) + ", plan=" + plan + "]";
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("in customer's equals");
		if (o instanceof Customer) {
			Customer c = (Customer) o;
			return this.email.equals(c.email);
		}
		return false;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		System.out.println("in cust compareto");
		return this.email.compareTo(anotherCustomer.email);
	}
}