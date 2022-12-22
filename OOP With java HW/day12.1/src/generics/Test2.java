package generics;

import java.util.List;
import java.util.Set;
import static generics.GenUtils.*;
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          List<Integer> l1=List.of(10,20,30,40);//AutoBoxing
          Set<Double> setdouble=Set.of(10.0,20.2,11.2);
          System.out.println(squareSum(l1));
          System.out.println(squareSum(setdouble));
	}

}
