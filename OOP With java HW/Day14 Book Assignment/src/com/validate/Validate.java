package com.validate;

import java.util.Map;

import com.app.core.Book;
import com.benum.Category;
import com.exception.ExceptionHendling;

public class Validate {
	public static String validateTitle(Map<String, Book> map, String title) throws ExceptionHendling {
		if (map.containsKey(title)) {
			throw new ExceptionHendling("This Book is already exists");
		}
		return title;
	}

	public static Category validateCategory(String category) throws ExceptionHendling {
		try{
			return Category.valueOf(category.toUpperCase());
		}catch(Exception e){
			throw new ExceptionHendling("Wrong Color");
	}
	}
	public static Book findByTitle(Map<String, Book> map,String title){
		if(map.containsKey(title)) {
			return map.get(title);
		}
		return null;
	}
}
