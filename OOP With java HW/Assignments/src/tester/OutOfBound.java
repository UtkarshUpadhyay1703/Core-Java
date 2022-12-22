package tester;
public class OutOfBound{
	public static void OutOfBound(int Specific_index,int index) throws OutOfBoundException {
		if(Specific_index<0 || Specific_index>index) {
			throw new OutOfBoundException("Invalid index");
		}
		System.out.println("Index is in range");
	}
}