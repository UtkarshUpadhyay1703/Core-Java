package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private Category bookCategory;
	private double price;
	private LocalDate publishDate;
	private String authorName;
	private int quantity;
	public Book(String title, Category bookCategory, double price, LocalDate publishDate, String authorName,
			int quantity) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
		this.price = price;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.quantity = quantity;
	}
}
