package utils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.ShowroomHandlingException;
import static com.app.core.Vehicle.sdf;

public class ValidationRules {
	public static final double MIN_PRICE;
	public static final double MAX_PRICE;
	public static Date beginDate;
	public static Date endDate;
	static {
		MIN_PRICE = 10000;
		MAX_PRICE = 100000;
		try {
			beginDate = sdf.parse("1-4-2022");
			endDate = sdf.parse("31-3-2023");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}
	}

	// add a static method for price validation
	public static double validatePrice(double price) throws ShowroomHandlingException {
		if (price < MIN_PRICE || price > MAX_PRICE)
			throw new ShowroomHandlingException("Price out of range !!!!!!!");
		// => price is valid
		return price;
	}

	// add a static method for color validation
	public static Color validateColor(String clr) throws ShowroomHandlingException {
		try {
			return Color.valueOf(clr.toUpperCase());
		} catch (IllegalArgumentException e) {
			StringBuilder sb = new StringBuilder("Available Colors \n ");
			sb.append(Arrays.toString(Color.values()) + "\n");
			sb.append("Choose correct color !");
			// wrong clr
			throw new ShowroomHandlingException(sb.toString());
		}
	}

	// add a static method for parsing n validating date
	public static Date parseAndValidateDate(String date) throws ParseException, ShowroomHandlingException {
		// parse : string ---> Date
		Date manuDate = sdf.parse(date);
		// parse succes --> continue to validation
		if (manuDate.before(beginDate) || manuDate.after(endDate))
			throw new ShowroomHandlingException("Invalid Date!!!!!!");
		// validation success
		return manuDate;
	}

	// add a static method to detect dup chasis no
	public static String validateChasisNo(String chasisNo, List<Vehicle> vehicleList) throws ShowroomHandlingException {
		// list : {v1(abc-1234),v2(abc-1235),.....v10,v11}
		// 1. Create a new vehicle instance wrapping UID (i.e chasis no)
		Vehicle newVehicle = new Vehicle(chasisNo);// abc-1235
		// 2 . List API : contains
		if (vehicleList.contains(newVehicle))
			throw new ShowroomHandlingException("Dup Vehicle !!!!!");
		return chasisNo;
	}

	// add a static method to find a vehicle by it's ch no
	public static Vehicle findByChasisNo(String chasisNo, List<Vehicle> vehicles) throws ShowroomHandlingException {
		// list : {v1(abc-1234),v2(abc-1235),.....v10(abc-1240),v11}
		Vehicle existingVehicle = new Vehicle(chasisNo);//abc-1240
		// API : indexOf
		int index = vehicles.indexOf(existingVehicle);
		//if(vehicles.contains(existingVehicle))
		if (index == -1)
			throw new ShowroomHandlingException("Vehicle not found!!!!!!!!!!!");
		//=> vehicle found
		return vehicles.get(index);
		}

}
