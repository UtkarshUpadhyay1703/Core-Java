package com.app.fruits;
public abstract class Fruit {
	private String colour;
	private Double weight;
	private String name;
	private Boolean fresh=true;
	public Fruit(String colour,Double weight,String name) {
		this.colour=colour;
		this.weight=weight;
		this.name=name;
		this.fresh=true;
	}
	public abstract String taste();
	@Override
	public String toString() {
		return "colour = "+colour+"Weight = "+weight+"Name"+name;
	}
	public void setFresh(Boolean fresh) {
		this.fresh = fresh;
	}
	public String getColour() {
		return this.colour;
	}
	public String getName() {
		return this.name;
	}
	public Double getWeight() {
		return this.weight;
	}
}