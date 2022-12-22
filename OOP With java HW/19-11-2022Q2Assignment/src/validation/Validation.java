package validation;

import java.util.ArrayList;

import custom.ExceptionHandler;
import enums.STATUS;
import taskmanager.TaskManager;

public class Validation {
	public static int checkId(int id, ArrayList<TaskManager> list) throws ExceptionHandler {
		if (list.contains(new TaskManager(id)))
			return id;
		throw new ExceptionHandler("Invalid id");
	}

	public static STATUS checkStatus(String status) throws ExceptionHandler {
		try {
			return STATUS.valueOf(status.toUpperCase());
		} catch (Exception e) {
			throw new ExceptionHandler("Invalid status");
		}
	}

	public static void updateStatus(String sts, int id, ArrayList<TaskManager> list) throws ExceptionHandler {
		int idx = checkId(id, list);
		STATUS st = checkStatus(sts);
		list.get(idx - 1).setStatus(st);
	}
}
