package tester;

import static utils.Utils.findChassi;
import static utils.Utils.populatedVehicle;
import static utils.Utils.validateColour;
import static utils.Utils.validateType;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.Vehicle;
import com.venum.Color;

import exceptionHendling.ExceptionHandler;

public class Test {

	public static void main(String[] args) throws ExceptionHandler {
		try (Scanner sc = new Scanner(System.in)) {
			List<Vehicle> list = populatedVehicle();
			int option;
			do {
				System.out.println(
						"Enter the choice 1.Add Vehicle, 2.Display all Vehicles, 3. Display all vehicles having specified color,"
						+ " 4.Apply discount to a particular vehicle,\n 5.DisplayWithEnum, 6.Sort according to date , 10. Exit");
				option = sc.nextInt();
				switch (option) {
				case 1:
					list.add(new Vehicle(sc.next(), validateColour(sc.next()), LocalDate.parse(sc.next()),
							validateType(sc.next()), sc.nextDouble()));
					break;
				case 2:
					for (Vehicle v : list)
						System.out.println(v);
					break;
				case 3:
					System.out.println("Enter Colour");
					Color color=validateColour(sc.next());
					for(Vehicle v:list)
						if(v !=null && v.getColour().equals(color))
							System.out.println(v);
					break;
				case 4:
					System.out.println("Enter Chessi No and Discount Percentage");
					Vehicle veh=findChassi(list, sc.nextInt());
					veh.setPrice(veh.getPrice()*((100-sc.nextDouble())*.01));
					break;
				case 5:
					for(Vehicle v:list)
					System.out.println(v.DisplayWithEnum());
					break;
				case 6:
					Collections.sort(list, new Comparator<Vehicle>() {
						@Override
						public int compare(Vehicle v1,Vehicle v2) {
							return v1.getMfdDate().compareTo(v2.getMfdDate());
						}
					});
					for(Vehicle v:list)
						System.out.println(v);
					break;
				}

			} while (option < 10);
		}
	}

}
