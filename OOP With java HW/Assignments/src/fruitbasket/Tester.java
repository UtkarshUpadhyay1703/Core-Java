package fruitbasket;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;

public class Tester {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size");
		int option,size=sc.nextInt();
		Fruit[] arr=new Fruit[size];
		int index=0;
		do {
		System.out.println("Enter a option 1.add Mango, 2.Add Orange, 3.Add Apple 4.Print all names 5.Print all names,weight,colour");
		 option=sc.nextInt();
		switch(option){
			case 1:
				if(index<arr.length)
				{
					arr[index]=new Mango(sc.next(),sc.nextDouble(),"Mango");
					index++;
				}
				break;
			case 2:
				if(index<arr.length)
				{
					arr[index]=new Orange(sc.next(),sc.nextDouble(),"Orange");
					index++;
				}
				break;
			case 3:
				if(index<arr.length)
				{
					arr[index]=new Apple(sc.next(),sc.nextDouble(),"Apple");
					index++;
				}
				break;
			case 4:
				for(Fruit f:arr)
					System.out.println(f.getName());
				break;
			case 5: 
				for(Fruit f:arr) {
					if(f!=null) {
					System.out.println(f.toString());
					System.out.println(f.taste());
					}
				}
				break;
			case 6:
				System.out.println("Enter index");
				int stale_index=sc.nextInt();
				if(stale_index<index) {
					arr[stale_index].setFresh(false);
				}
				else {
					System.out.println("Invalid case");
				}
				break;
			case 7:
				for(int j=0;j<size;j++) {
					if((arr[j].taste()).equals("sour")) {
						arr[j].setFresh(false);
					}
				}
			case 8:
				 int spacific_index=sc.nextInt();
				if(spacific_index<index) {
						if(arr[spacific_index] instanceof Mango) 
						((Mango)arr[spacific_index]).pulp();
						else if(arr[spacific_index] instanceof Orange) 
						((Orange)arr[spacific_index]).juice();
						else if(arr[spacific_index] instanceof Apple) 
						((Apple)arr[spacific_index]).jam();
					}
				else {
					System.out.println("Invalid case");
				}
				break;
			case 10:
				System.out.println("Exit");
				break;
		}
		}while(option!=10);
	}
}