package com.app.fruits;

public class Orange extends Fruit {
	public Orange(String colour,Double weight,String name) {	
		super(colour,weight,name);
		}
	public void juice() {
		System.out.println("Name = "+getName()+"Weight = "+getWeight()+"mesg extracting juice!");
	}
	public String taste() {
		return "Sour";
	}
}
