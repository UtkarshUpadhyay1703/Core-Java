package com.app.org;
public class Mgr extends Emp{
	private double prefbonus;
	public Mgr(String firstname,String lastname,int deptno,double basic,double prefbonus) {
	super(firstname,lastname,deptno,basic);
		this.prefbonus=prefbonus;	
	}
//	public net_sal
	@Override
	public Double net_sal() {
		return (getBasic()+prefbonus);
	}
	@Override
	public String toString() {
		return (super.toString()+"prefbonus = "+prefbonus);
	}
}
