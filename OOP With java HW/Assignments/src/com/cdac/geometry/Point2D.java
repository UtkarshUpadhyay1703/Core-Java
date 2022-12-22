package com.cdac.geometry;
import java.lang.Math;
public class Point2D {
	private int x;
	private int y;
	public Point2D(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public String show() {
		return "x="+x+"y="+y;
	}
	public Boolean isequal(Point2D p) {
		if(this.x==p.x && this.y==p.y) {
		return true;	
		}
		else {
			return false;
	}
	}
	public Double calculateDistance(Point2D point2) {
		double x1=this.x-point2.x;
		double y1=this.y-point2.y;
		double x2=x1*x1;
		double y2=y1*y1;
		double Dis=x2+y2;
		double distance=Math.sqrt(Dis);
		return distance;
	}
	
}