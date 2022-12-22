package com.app;

import java.time.LocalDate;

import com.venum.Color;
import com.venum.Type;

public class Vehicle {
	private static int counter;
	private String model;
	private Color colour;
	private LocalDate mfdDate;
	private int chassiNo;
	private Type type;
	private double price;
	private final static String companyName;
	static {
		companyName = "Tata";
		counter = 1000;
	}

	public Vehicle(int chassino) {
		this.chassiNo = chassino;
	}

	public Vehicle(String model, Color colour, LocalDate mfdDate, Type type, double price) {
		super();
		this.model = model;
		this.colour = colour;
		this.mfdDate = mfdDate;
		this.type = type;
		this.price = price;
		this.chassiNo = counter++;
	}

	@Override
	public boolean equals(Object anotherObject) {
		if (anotherObject instanceof Vehicle) {
			Vehicle v = (Vehicle) anotherObject;
			return this.chassiNo == v.chassiNo;
		}
		return false;
	}

	@Override
	public String toString() {
		return "vehicle [model=" + model + ", colour=" + colour + ", mfdDate=" + mfdDate + ", chassiNo=" + chassiNo
				+ ", type=" + type + "Price=" + price + "]";
	}
	public String DisplayWithEnum() {
		return this.toString()+"Price with color price=" + (price+colour.getAdditional()) + "]";
	}
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Vehicle.counter = counter;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public LocalDate getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(LocalDate mfdDate) {
		this.mfdDate = mfdDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public static String getCompanyname() {
		return companyName;
	}

	public int getChassiNo() {
		return chassiNo;
	}

	public void setChassiNo(int chassiNo) {
		this.chassiNo = chassiNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
