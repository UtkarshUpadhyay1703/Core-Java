package generics;

import java.util.List;
import java.util.Set;

import static generics.GenUtils.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = List.of(10, 20, 30, 40, 50);// unmodifiable list
		printDetails(l1);
		System.out.println("-----------------------------------------------");
		printDetails2(l1);
		// l1.add(15);//Not possible to (ImmutableCollections.java:71)
		// l1.set(0, 166);//Not possible to (ImmutableCollections.java:71)
		Set<Double> doubleset = Set.of(1.5, 45d, 63.2);
		printDetails(doubleset);
		System.out.println("----------------------");
		printDetails2(doubleset);

	}

}
