package com.app.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.benum.Category;

public class Book {
	private String title;
	private String author;
	private LocalDate publishDate;
	private double price;
	private Category category;
	private int quantity;

	public Book(String title) {
		this.title=title;
	}
	public Book(String title, String author, LocalDate publishDate, double price, Category category, int quantity) {
		super();
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	@Override
	public boolean equals(Object anotherObject) {
		if(anotherObject instanceof Book) {
			return this.getTitle().equals(((Book)anotherObject).getTitle()); 
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publishDate=" + publishDate.format(DateTimeFormatter.ofPattern("dd/MMM/YYYY")) + ", price=" + price
				+ ", category=" + category + ", quantity=" + quantity + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
