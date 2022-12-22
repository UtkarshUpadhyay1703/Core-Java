package utils;

import java.util.HashMap;
import java.util.Map;
import com.app.core.Category;
import com.app.core.Book;
import static java.time.LocalDate.parse;
import static com.app.core.Category.*;

public class LibUtils {
	public static Map<String,Book> populateLibrary(){
		Map<String,Book> map=new HashMap<>();
		map.put("sc-001", new Book("sc-001",SCIENCE,500,parse("2020-01-19"),"Riya",50));
		map.put("sc-009", new Book("sc-009",FICTION,600,parse("2020-11-19"),"Ravi",40));
		map.put("sc-003", new Book("sc-003",SCIENCE,560,parse("2019-11-19"),"Riya",30));
		map.put("sc-005", new Book("sc-005",TECHNOLOGY,400,parse("2022-01-19"),"Mihir",50));
		map.put("sc-002", new Book("sc-002",SCIENCE,530,parse("2022-06-19"),"Riya",55));
		return map;
	}
	
}
