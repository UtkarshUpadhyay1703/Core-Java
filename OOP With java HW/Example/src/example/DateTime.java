package example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public static void main(String[] args) {
		LocalDate l1 = LocalDate.parse("2100-05-25");
		System.out.println(l1.format(DateTimeFormatter.ofPattern("MM/dd/YYYY")));
	}

}
