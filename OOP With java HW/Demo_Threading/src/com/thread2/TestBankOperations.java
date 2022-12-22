package com.thread2;

public class TestBankOperations {

	public static void main(String[] args) {
	
	final	BankAccount act=new  BankAccount(1000);
		
		//withdraw(2000)---->3000
		//deposite(4000)----->7000
		
		BankOp1 t1=new BankOp1(act);//to set name of thread then either we have to pass thread name via
		//Parameterized constructor or use setName with reference_variable.setName function.
		t1.setName("BankOp1");
		
		BankOp2 t2=new BankOp2(act);
		t2.setName("BankOp2");
		t1.start();
		System.out.println(t1.getName());
		t2.start();
		
		//
		//
		
		
		

	}

}
