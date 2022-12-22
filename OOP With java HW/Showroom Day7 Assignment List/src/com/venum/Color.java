package com.venum;

public enum Color {
	RED(2000), YELLOW(2500), ORANGE(3000), BLACK(4000), WHITE(1000), BLUE(1500);

	private double additional;

	Color(double additional) {
		this.additional = additional;
	}

	public double getAdditional() {
		return additional;
	}

	public void setAdditional(double additional) {
		this.additional = additional;
	}

}
