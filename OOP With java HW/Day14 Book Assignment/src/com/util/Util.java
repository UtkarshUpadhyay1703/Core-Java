package com.util;

import static com.benum.Category.*;
import static java.time.LocalDate.parse;

import java.util.HashMap;
import java.util.Map;

import com.app.core.Book;

public class Util {
	public static Map<String, Book> populated() {
		Map<String, Book> map = new HashMap<>();
		// String title, String author, LocalDate publishDate, double price, Category
		// category, int quantity) {

		map.put("bku", new Book("bku", "Riya", parse("2020-01-19"), 500, SCIENCE, 50));

		map.put("bkk", new Book("bkk", "Ravi", parse("2020-11-19"), 600, FICTION, 40));

		map.put("bke", new Book("bke", "Riya", parse("2022-06-19"), 530, COMIC, 55));

		map.put("bka", new Book("bka", "Riya", parse("2019-11-19"), 560, SCIENCE, 30));

		map.put("bkw", new Book("bkw", "Mihir", parse("2022-01-19"), 400, TECHNOLOGY, 45));

		return map;
	}
}
