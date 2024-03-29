package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * id(int) name(string),email(string),password(string),registrationAmount(double),dob(Date),plan(ServicePlan : enum)
 */
public class Customer implements Comparable<Customer> {
//state : non static data members
	private int customerId;
	private String name;
	private String email;
	private String password;
	private double regAmount;
	private Date dob;
	private ServicePlan plan;
	// static
	public static int idGenerator;
	public static SimpleDateFormat sdf;
	// static init block
	static {
		idGenerator = 1;
		sdf = new SimpleDateFormat("d/M/y");
	}

	// all args ctor
	public Customer(String name, String email, String password, double regAmount, Date dob, ServicePlan plan) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.customerId = idGenerator++;
	}

	// 1 arg ctor : to init UID (email)
	// toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", regAmount=" + regAmount
				+ ", dob=" + sdf.format(dob) + ", plan=" + plan + "]";
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

	// Natural ordering
	@Override
	public int compareTo(Customer anotherCustomer) {
		System.out.println("in cust : compareTo");
		return this.email.compareTo(anotherCustomer.email);
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getEmail() {
		return this.email;
	}
	public Date getDate() {
		return this.dob;
	}
	public ServicePlan getServicePlan() {
		return this.plan;
	}
}
