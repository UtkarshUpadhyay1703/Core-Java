package com.funInterfaceDemo;

public class TestLambdaExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//function with no name
		//Lambda Exprs are used for Functional Interface
		MyFunctionalInterface fun1= ()->System.out.println("This is MyFunction");//When we write a statement in lambda
		//expression it workes as a overriden method of self created SAM from functional interface;
		
		fun1.myFunction();
		
		fun1=()->System.out.println("------------------");
		fun1.myFunction();
		
		fun1=()->{
			for(int i=1;i<=10;i++)
				System.out.println(i);
		};
		
		fun1.myFunction();
	}

}
