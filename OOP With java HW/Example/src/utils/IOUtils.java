package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import static utils.LibUtils.populateLibrary;
import com.app.core.Book;

public class IOUtils {
	public static void storeBookDetails(String fileName,Map<String,Book> book)throws IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(book);
			System.out.println("Stored book details successfully!");
		}
	}
	public static Map<String,Book> restoreDetails(String fileName) throws ClassNotFoundException, IOException {
		File f1=new File(fileName);
		if(f1.isFile() && f1.canRead()) {
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1))){
				return (Map<String,Book>) in.readObject();
			}	
		}
		System.out.println("Invalid File!!!!!!!!!!!");
		return populateLibrary();
	}
}
