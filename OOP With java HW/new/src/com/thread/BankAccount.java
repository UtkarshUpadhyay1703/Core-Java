package com.thread;

public class BankAccount {
	public class BankAccount {
		private double balance;
		public BankAccount(double balance) {
		this.balance = balance;
		}
		@Override
		public String toString() {
		return &quot;BankAccount [balance=&quot; + balance + &quot;]&quot;;
		}
		public synchronized void withdraw(double amount) throws
		InterruptedException {
		System.out.println(&quot;started by : &quot; +
		Thread.currentThread().getName());
		if (balance &lt; amount) {
		Thread.sleep(1000);

		System.out.println(&quot;Waiting for deposite&quot;);
		super.wait();
		}
		this.balance = this.balance - amount;
		System.out.println(&quot;after withdraw &quot; + balance);
		System.out.println(&quot;Ended by : &quot; +
		Thread.currentThread().getName());
		}
		public synchronized void deposite(double amount) {
		System.out.println(&quot;Started by :&quot; +
		Thread.currentThread().getName());
		this.balance = this.balance + amount;
		System.out.println(&quot;after deposite : &quot; + balance);
		System.out.println(&quot;Ended by : &quot; +
		Thread.currentThread().getName());
		super.notify();
		}
}
