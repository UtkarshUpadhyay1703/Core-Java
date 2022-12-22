package com.app.fruits;
public class Apple extends Fruit {
	public Apple(String name,Double weight,String colour) {
		super(name,weight,colour);
	}
	public void jam() {
		System.out.println("Name = "+getName()+"mesg making jam!");
	}
	public String taste() {
		return "Sweet and Sour";
	}
}