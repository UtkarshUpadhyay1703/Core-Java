package Tester;

import static com.util.Util.populated;
import static com.validate.Validate.findByTitle;
import static com.validate.Validate.validateCategory;
import static com.validate.Validate.validateTitle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Book;
import com.benum.Category;
import com.exception.ExceptionHendling;

public class Test {

	public static void main(String[] args) throws ExceptionHendling {
		try(Scanner sc=new Scanner(System.in)){
		Map<String, Book> map=populated();
		int option;
		do {
			System.out.println("Enter option 1.Add a book, 2.Display all Books, 3.Find by title, "
					+ "\n4.sort by title, 5.Sort by price, 6.Decending of title\n"
					+ "7.Sort by author name, 8.Sort by category ,9. sort by date");
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("How many");
				int qty=sc.nextInt();
				while(qty!=0) {
				System.out.println("String title,String title, String author, LocalDate publishDate, "
						+ "double price, Category category, int quantity");
				map.put(validateTitle(map,sc.next()), new Book(validateTitle(map,sc.next()),
						sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(), 
						validateCategory(sc.next()), sc.nextInt()));
				qty=qty-1;
				}
				break;
			case 2:
				for(Book b:map.values()) {
					System.out.println(b);
				}
				break;
			case 3:
				System.out.println("Enter title of book");
				System.out.println(findByTitle(map,sc.next()));
				break;
			case 4:
				TreeMap<String, Book> bk=new TreeMap<String, Book>(map);
				for(Book b:bk.values())
					System.out.println(b);
				break;
			case 5:
				ArrayList<Book> allBook=new ArrayList<Book>(map.values());
//				Collections.sort(allBook, new Comparator<Book>() {
//				@Override
//				public int compare(Book B1, Book B2) {
//					return ((Double)B1.getPrice()).compareTo(B2.getPrice());
//				}
//				});
//				for(Book b:allBook)
//					System.out.println(b);
				//OOOOORRRRR
				Collections.sort(allBook,(p1,p2) ->{
					return ((Double)p1.getPrice()).compareTo(p2.getPrice());
				});
				System.out.println();
				allBook.forEach(p -> System.out.println(p));
				
				break;
			case 6:
				TreeMap<String, Book> sortedbk=new TreeMap<>(new Comparator<String>() {
					@Override
					public int compare(String S1, String S2) {
						return S2.compareTo(S1);
					}
				});
				sortedbk.putAll(map);
				for(Book b:sortedbk.values())
					System.out.println(b);
				break;
			case 7:
				ArrayList<Book> book1=new ArrayList<Book>(map.values());
				//book1.sort(Comparator<T>);
//				Collections.sort(book1, new Comparator<Book>() {
//					@Override
//					public int compare(Book b1, Book b2) {
//						return ((String)b1.getAuthor()).compareTo(b2.getAuthor());
//					}
//				});
				Collections.sort(book1, (o1,o2)->{return((String)o1.getAuthor()).compareTo(o2.getAuthor());});
				for(Book b : book1)
					System.out.println(b);
//				Collections.sort(book1, (o1,o2)->{
//					return ((String)o1.getAuthor()).compareTo(o2.getAuthor());});
				for(Book b:book1)
					System.out.println(b);
				break;
			case 8:
				ArrayList<Book> newBook = new ArrayList<Book>(map.values());
				Collections.sort(newBook,new Comparator<Book>() {
					@Override
					public int compare(Book b1,Book b2) {
						return ((Category)b1.getCategory()).compareTo(b2.getCategory());
					}
				});
					for(Book b:newBook)
						System.out.println(b);
						
				
			}
		}while(option!=10);
		

	}
	}
}
