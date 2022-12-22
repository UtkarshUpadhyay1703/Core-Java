package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.accenum.AccType;
import static com.accenum.AccType.*;
import com.app.Bank;

public class Utils {
	//To populate the Bank
	List<Bank> list=new ArrayList();
	Bank B1=new Bank("Tanmay", "Kul", "tan@gmail.com", "tan@k12", 1234, 5400, PF, LocalDate.parse("2022-07-05"));
	Bank B2=new Bank("Yash", "Guj", "ysh@gmail.com", "ysg@k23", 4325, 6400, SAVINGS, LocalDate.parse("2022-07-15"));
	Bank B3=new Bank("Vaibhav", "Gupta", "vai@gmail.com", "vai@k12", 6204, 4400, CURRENT, LocalDate.parse("2022-05-15"));
	Bank B4=new Bank("Abhinav", "Pandey", "abh@gmail.com", "abh@k12", 1203, 5240, DEMAT, LocalDate.parse("2020-07-05"));
	Bank B5=new Bank("Nikhil", "Sol", "ni@gmail.com", "Ni@k12", 1234, 2600, PF, LocalDate.parse("2022-07-25"));
}

