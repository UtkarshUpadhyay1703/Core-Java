package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.dal.IBookDAL;
import com.pojo.Book;
import com.util.DbUtil;
//DAO-pattern(Data access object).
public class BookDALImpl implements IBookDAL {
	private Connection con;
	private PreparedStatement pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt9;

//use constr for con
	public BookDALImpl() throws ClassNotFoundException, SQLException {
		System.out.println("---BookDalImpl--constr--invoked---");
		// connection:get con obj from DbUtil
		con = DbUtil.getConnectedToDb();

		pstmt1 = con.prepareStatement("insert into books values(?,?,?,?)");
		pstmt2 = con.prepareStatement("update books set title=?,author=?,price=? where bookid=?");
		pstmt3 = con.prepareStatement("select * from books where bookid=?");
		pstmt4 = con.prepareStatement("delete from books where bookid=?");
		pstmt5 = con.prepareStatement("Select * from books where author=?");
		pstmt9 = con.prepareStatement("delete from books where author=?");
	}

	@Override
	public List<Book> getAllBooks() {

		List<Book> allBooks = new ArrayList<Book>();
		// select * from books
		String sql = "select * from books";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);// from db in resultSet ---->AL
			while (rset.next()) {
				allBooks.add(new Book(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4)));
			}

			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allBooks;

	}

	@Override
	public String addBook(Book obj) {

		try {
			// add first parameter to pstmt1
			pstmt1.setInt(1, obj.getBookId());
			// add second parameter
			pstmt1.setString(2, obj.getTitle());
			// add second parameter
			pstmt1.setString(3, obj.getAuthor());
			// add second parameter
			pstmt1.setDouble(4, obj.getPrice());

			// fire query
			// insert,update delete:write operation on db
			// executeUpdate
			int i = pstmt1.executeUpdate();
			if (i > 0)
				return " Inserted:";
			else
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookById(int bookid) {

		try {
			pstmt3.setInt(1, bookid);

			ResultSet rset = pstmt3.executeQuery();
			if (rset.next()) {
				return new Book(rset.getInt("bookId"), rset.getString("title"), rset.getString("author"),
						rset.getDouble("price"));
			} else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		con.close();

		System.out.println("---cleanup done----");
	}

	@Override
	public String updateBook(Book obj) throws SQLException {

		CallableStatement cstmt = con.prepareCall("call UpdateBook(?,?,?,?)");
		cstmt.setInt(1, obj.getBookId());
		cstmt.setString(2, obj.getTitle());
		cstmt.setString(3, obj.getAuthor());
		cstmt.setDouble(4, obj.getPrice());

		int i = cstmt.executeUpdate();
		if (i > 0)
			return "Updated:";
		else
			return null;

	}
	@Override
	public int deleteByBookid(int bookid) throws SQLException {
		pstmt4.setInt(1, bookid);
		int s=pstmt4.executeUpdate();
		return s;
	}
	@Override
	public Book getBookByAuthor(String author) throws SQLException {
		pstmt5.setString(1, author);
		 ResultSet rset=pstmt5.executeQuery();
		 if(rset.next()) {
			 return new Book(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4));
		 }
		 else return null;
	}
	@Override
	public double sumOfPrice() {
		List<Book> list=getAllBooks();
		double p=list.stream()
		.mapToDouble(x-> x.getPrice())         //Method chaining
		.sum();
		return p;
	}
	@Override
	public OptionalDouble maxOfPrice() {
		List<Book> list=getAllBooks();
		OptionalDouble p=list.stream()
				.mapToDouble(x-> x.getPrice())
				.max();
		return p;
	}

	
	@Override
	public int deleteByAuthor(String author) throws SQLException {
		pstmt5.setString(1, author);
		int s=pstmt9.executeUpdate();
	return s;	
	}
}
