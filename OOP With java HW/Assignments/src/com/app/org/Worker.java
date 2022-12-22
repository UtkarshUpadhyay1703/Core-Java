package com.app.org;
public class Worker extends Emp {
	private int hoursworked;
	private int hourlyrate;
	public Worker(String firstname, String lastname, int deptno, Double basic,int hoursworked,int hourlyrate) {
		super(firstname, lastname, deptno, basic);
		this.hourlyrate=hourlyrate;
		this.hoursworked=hoursworked;
	}
	@Override
	public String toString() {
		return  ("toString()="+super.toString()+"hoursworked=" + hoursworked + ", hourlyrate=" + hourlyrate);
	}
	@Override
	public Double net_sal() {
		return (getBasic()+(hourlyrate*hoursworked));
	}
	

}