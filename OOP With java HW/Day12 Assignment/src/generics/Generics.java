package generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fruits.Fruit;
import fruits.Mango;

public class Generics {
	public static void Display(Collection<?> collections) {
		Iterator<?> itr= collections.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
	}
	public static double SqrtSum(Collection<? extends Number> collections) {
		double sum=0;
		for(Number n:collections) {
			sum=sum+(double)n;
			System.out.println(n.doubleValue());
		}
		return sum;
	}
	public static void displayTastes(List<? extends Fruit> list)
	{
		Iterator<? extends Fruit> itr=list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().taste());
	}
	public static void addMango(List<? super Mango> list,Mango m) {
		list.add(m);
	}
	public static <T extends Number & Comparable<T>> T findMaxNumber(List<T> list)
	{
		T max=list.get(0);
		for(int i=1;i<list.size();i++)
			if(max.compareTo(list.get(i)) < 0)
				max=list.get(i);
		return max;
	}
}
