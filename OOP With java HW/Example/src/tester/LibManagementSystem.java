package tester;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import static utils.IOUtils.*;
import com.app.core.Book;

import custom_exception.LibraryHandlingException;

public class LibManagementSystem {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter file name to restore ");
			String fileName=sc.nextLine();
			Map<String,Book> library = restoreDetails(fileName);
//			System.out.println("Lib contains");
//			//display books
//			for(Book b: library.values())
//				System.out.println(b);
//			//store books
//			storeBookDetails(fileName,library);
			boolean exit=false;
			while(!exit) {
				System.out.println("1.Display All books,2.Remove a book");
				try{
					switch(sc.nextInt()) {
					case 1:
					for(Book b:library.values())
						System.out.println(b);
					break;
					case 2:
						System.out.println("Enter book title");
						Book removeBook=library.remove(sc.next());
						if(removeBook==null)
							throw new LibraryHandlingException("Invalid Book Title");
						break;
					case 100:
						exit=true;
						storeBookDetails(fileName, library);
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
