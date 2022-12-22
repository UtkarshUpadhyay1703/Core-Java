package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.venum.Color.*;
import static com.venum.Type.*;
import com.app.Vehicle;
import com.venum.*;

import exceptionHendling.ExceptionHandler;

public class Utils {
	public static List<Vehicle> populatedVehicle() {
		List<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle("NEXON", BLUE, LocalDate.parse("2022-05-11"), SUV, 100000.00));
		list.add(new Vehicle("SAFARI", YELLOW, LocalDate.parse("2022-05-12"), SUV, 200000.00));
		list.add(new Vehicle("PUNCH", WHITE, LocalDate.parse("2022-05-15"), SADAN, 50000.00));
		list.add(new Vehicle("TIAGO", BLACK, LocalDate.parse("2022-05-10"), HATCHBACK, 20000.00));
		list.add(new Vehicle("ALTROS", BLUE, LocalDate.parse("2022-05-09"), SUV, 150000.00));
		return list;
	}

	public static Color validateColour(String color) throws ExceptionHandler {
		try {
			return Color.valueOf(color.toUpperCase());
		} catch (Exception e) {
			throw new ExceptionHandler("Enter right colour");
		}
	}

	public static Type validateType(String type) throws ExceptionHandler {
		try {
			return Type.valueOf(type.toUpperCase());
		} catch (Exception e) {
			throw new ExceptionHandler("Enter right Type");
		}
	}

	public static Vehicle findChassi(List<Vehicle> list, int chassi) throws ExceptionHandler {
		for (Vehicle v : list)
			if (v != null && v.getChassiNo() == chassi)
				return v;
		throw new ExceptionHandler("Entered chassi number not exists");
	}

}