package com.app;

import java.time.LocalDate;

import com.accenum.AccType;

public class Bank {
	private int accno;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double balance;
	private AccType acctype;
	private LocalDate dtopen;
	private long aadharno;
	private static int Idcount;
	static {
		Idcount = 1001;
	}

	public Bank(String fname, String lname, String email, String password, double balance, long aadharno,
			AccType acctype, LocalDate dtopen) {
		super();
		this.accno = Idcount;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.acctype = acctype;
		this.dtopen = dtopen;
		this.aadharno = aadharno;
		Idcount++;
	}

	@Override
	public String toString() {
		return "Bank [accno=" + accno + ", First name=" + lname + ", Last name=" + lname + ", email=" + email
				+ "Aadhar Number=" + aadharno + ", password=" + password + ", balance=" + balance + ", acctype="
				+ acctype + ", dtopen=" + dtopen + "]";
	}

	public long getAadharno() {
		return aadharno;
	}

	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccType getAcctype() {
		return acctype;
	}

	public void setAcctype(AccType acctype) {
		this.acctype = acctype;
	}

	public LocalDate getDtopen() {
		return dtopen;
	}

	public void setDtopen(LocalDate dtopen) {
		this.dtopen = dtopen;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public void deposite(double amount) {
		this.balance += amount;
	}
	public void fundTransfer(double amount,Bank reciever) {
		this.withdraw(amount);
		reciever.deposite(amount);
	}
	public double validateBalance(double amount) {
		if(this.balance>amount) 
			return amount;
		throw new 
		
	}
	@Override
	public boolean equals(Object anotherObject) {
		if (anotherObject instanceof Bank) {
			Bank b = (Bank) anotherObject;
			return this.getAccno() == b.getAccno();
		}
		return false;
	}
}
