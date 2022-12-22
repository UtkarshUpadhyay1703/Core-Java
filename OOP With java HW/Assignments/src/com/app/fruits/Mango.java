package com.app.fruits;
public class Mango extends Fruit {
	
public Mango(String colour, Double weight, String name) {
		super(colour, weight, name);
		// TODO Auto-generated constructor stub
	}
public void pulp() {
	System.out.println("Colour = "+getColour()+"Name = "+getName()+"Msg = creating  pulp!");
}
@Override
public String taste() {
	return "Sweet";
}
}