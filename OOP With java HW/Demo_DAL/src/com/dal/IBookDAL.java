package com.dal;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;

import com.pojo.Book;

public interface IBookDAL {
//DAL(Data Access Layer).
	// what to do on Book

	List<Book> getAllBooks() throws SQLException;// select * from books

	String addBook(Book obj) throws SQLException;//
	// Lab Task:updateBook ,deleteBook

	Book getBookById(int bookid);

	// List<Book> getBookByAuthor(String author);
	String updateBook(Book obj) throws SQLException;

	int deleteByBookid(int bookid) throws SQLException;
	int deleteByAuthor(String author) throws SQLException;
	Book getBookByAuthor(String author) throws SQLException;
	double sumOfPrice();
	OptionalDouble maxOfPrice();
}
