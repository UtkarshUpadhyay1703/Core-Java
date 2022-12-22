package generics;

import java.util.Collection;
import java.util.Iterator;

public class GenUtils {
	/*
	 * Write a method to print elements from ANY collection of any type eg
	 * AL/LL/Vector | HS/LHS/TS : String /Customer/ Date
	 */
	public static void printDetails(Collection<?> collection) {// not a generic but using unbounded
		for (Object c : collection) // Example of implicit iteretor because we not used iterator
			System.out.println(c);
		Iterator<?> itr = collection.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

	// can above method be written using T ? Yes
	public static <T> void printDetails2(Collection<T> collection) {// Generic syntax <T>
		for (T t : collection)
			System.out.println(t);

		Iterator<T> itr = collection.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

	public static double squareSum(Collection<? extends Number> collection) {
		double sum = 0;
		for (Number n : collection)
			sum += n.doubleValue();
		return Math.sqrt(sum);
	}
}
