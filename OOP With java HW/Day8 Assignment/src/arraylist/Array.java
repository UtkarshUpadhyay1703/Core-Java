package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);) {
			///4.1
		ArrayList<String> StringList = new ArrayList<>();
		String[] Stringarray= {"One","Two","Three","Four","Five",
			"Six","Seven","Eight","Nine","Ten","Three","Five"};
		for(String data:Stringarray)
			StringList.add(data);
		//4.2
		
		for(String data:StringList)
			System.out.print(data+" ");
//		System.out.println();
//		for(int i=0;i<StringList.size();i++) {
//			System.out.print(StringList.get(i)+" ");
//		}
		System.out.println();
		//4.3
		System.out.println("Enter a string");
		String Str=sc.next();
//		int x;
//		for(String data:StringList) {
//			x=(data.compareTo(Str));
//		if(x==0) {
//			System.out.println("Exist");
//			break;
//		}
//		}
		System.out.println(StringList.contains(Str)?"Exists":"Not Exists");
		System.out.println();
		//4.4
		System.out.println("Upper case all the strings from the array list , which starts with char 't'");
		for(int i=0;i<StringList.size();i++) {
			Boolean Flag=StringList.get(i).startsWith("T");
			if(Flag) {
				StringList.set(i, StringList.get(i).toUpperCase());
			}
		}
		for(String data:StringList)
			System.out.print(data+" ");
		System.out.println();
		
		//4.5		
		System.out.println("Enter index to be removed");
		int index=sc.nextInt();
		StringList.remove(index);
		for(String data:StringList)
			System.out.print(data+" ");
		System.out.println();
		
		//4.6
		System.out.println("Copy a Array");
		ArrayList<String> StringListCopy=new ArrayList<String>(StringList);
		for(String data:StringListCopy)
			System.out.print(data+" ");
		System.out.println();
		
		//4.7
		System.out.println("Sorted Array");
		Collections.sort(StringList);
		for(String data:StringList)
			System.out.print(data+" ");
		System.out.println();
		
		//4.8
		System.out.println("Remove all the strings from the 2nd list , containing a char 'e'");
//		for(int i=0;i<StringListCopy.size();i++) {
//			if(StringListCopy.get(i).contains("e")) {
//				StringListCopy.remove(i);
//				i--;
//			}
//		}
		
		Iterator<String> itr = StringListCopy.iterator();
		while(itr.hasNext()) {
			if(itr.next().contains("e"))
			itr.remove();			
		}
		for(String data:StringListCopy)
			System.out.print(data+" ");
		System.out.println();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}