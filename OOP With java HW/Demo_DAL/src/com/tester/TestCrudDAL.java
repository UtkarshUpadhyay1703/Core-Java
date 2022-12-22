package com.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.dao.BookDALImpl;
import com.pojo.Book;

public class TestCrudDAL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("1:GetAllBooks " + "2:Insert " + "3:Update " + "4:Delete " + "5: getBookById "
				+ "6:GetBookByAuthor 7:Sum Of price 8:Max price 9:DeleteBookByAuthor");

		BookDALImpl bookDal = new BookDALImpl();

		// Client is getting data in Collection
		// System.out.println("--------------------------------");
		// allBooks.forEach(System.out::println);
		int ch;
		try(Scanner sc = new Scanner(System.in)){
		do {
			System.out.println("Enter Choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				List<Book> allBooks = bookDal.getAllBooks();
				allBooks.forEach(b -> System.out.println(b));
				break;
			case 2:// insert
				System.out.println("BookId Title Author Price");
				Book newBook = new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
				//
				String result = bookDal.addBook(newBook);
				if (result != null)
					System.out.println(result);

				break;
			case 3:// update
				System.out.println("BookId Title Author Price");
				Book editBook = new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
				result = bookDal.updateBook(editBook);
				if (result != null)
					System.out.println(result);
				break;
			case 4:// delete
				System.out.println("Enter book id");
				if (bookDal.deleteByBookid(sc.nextInt()) != 0) {
					System.out.println("Deleted");
				} else
					System.out.println("no such book found");
				break;
			case 5:// getBookById
				System.out.println("Enter BookId");
				Book obj = bookDal.getBookById(sc.nextInt());
				if (obj != null)
					System.out.println(obj);
				else
					System.out.println("Not found");

				break;
			case 6:// GetBookByAuthor
				System.out.println("Enter Author name");
				obj = bookDal.getBookByAuthor(sc.next());
				if (obj != null)
					System.out.println(obj);
				else
					System.out.println("Not found");
				break;
			case 7://Sum Of price
				double price=bookDal.sumOfPrice();
				System.out.println(price);
				break;
			case 8://Max price
				OptionalDouble price1=bookDal.maxOfPrice();
				System.out.println(price1);
				break;
			case 9:// DeleteBookByAuthor
				System.out.println("Enter Author name");
				if (bookDal.deleteByAuthor(sc.next()) != 0)
					System.out.println("Deleted");
				else
					System.out.println("no such book found");
				break;
			case 10:// cleanup
				bookDal.cleanUp();
				break;
			}

		} while (ch != 10);

	}
	}

}
