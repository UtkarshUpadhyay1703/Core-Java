package validation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import enums.STATUS;
import taskmanager.TaskManager;

public class HashValidation {
	public static HashMap<Integer,TaskManager> populateHash(){
		HashMap<Integer, TaskManager> tm=new HashMap<Integer, TaskManager>();
		tm.put(0, new TaskManager("abc","xyz", LocalDate.parse("2022-02-01")));
		tm.put(0, new TaskManager("ac","we", LocalDate.parse("2012-02-01")));
		tm.put(0, new TaskManager("bc","sa", LocalDate.parse("2032-02-01")));
		tm.put(0, new TaskManager("ab","ds", LocalDate.parse("2021-02-01")));
		tm.put(0, new TaskManager("absc","gf", LocalDate.parse("2012-05-01")));
		return tm;
	}
	
//	public static boolean delete(int id,Map<Integer, TaskManager> map) {
//		int x=CheckId(null, id)
//	}
	
	public static int CheckId(Map<Integer, TaskManager> map, int id) {
		if (map.containsKey(id))
			return id;
		return -1;
	}

	public static STATUS validateStatus(String status) {
		return STATUS.valueOf(status.toUpperCase());
	}
}
