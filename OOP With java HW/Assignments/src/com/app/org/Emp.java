package com.app.org;
public abstract class Emp {
	private String firstname;
	private String lastname;
	private int deptno;
	private int id;
	private double basic;
	public Emp(String firstname,String lastname,int deptno,Double basic) {
	this.firstname=firstname;
	this.lastname=lastname;
	this.deptno=deptno;
	this.basic=basic;
	this.id=counter;
	counter++;
	}
	public static int counter;
	static {
		counter=1;
	}
	public abstract Double net_sal();
	@Override
	public String toString() {
		return ("Employee id =  "+id+" First Name = "+firstname+" Lastname = "+lastname+" Deptno = "+deptno+" Basic sal = "+basic);
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic=basic;
	}
}