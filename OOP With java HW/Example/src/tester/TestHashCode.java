package tester;

import java.util.HashSet;

import com.app.core.Emp;

public class TestHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Aa".equals("BB"));
System.out.println("Aa".hashCode()+" "+"BB".hashCode());
Emp e1=new Emp("Aa","Raj",123);
Emp e2=new Emp("BB","Rama",223);
HashSet<Emp> emps=new HashSet<>();
System.out.println(emps.add(e1));//t,hc:1,eq:0
System.out.println(emps.add(e2));//t,hc:1,eq:1
System.out.println(emps.size());
	}

}
