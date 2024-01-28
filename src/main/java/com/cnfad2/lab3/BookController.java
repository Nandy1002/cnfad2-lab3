package com.cnfad2.lab3;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {
	
	private final List<Book> books = new ArrayList<Book>();
	//Book book = new Book("1234", "ABCD", "XYZ");
	
	@GetMapping
	public List<Book> getAllBooks() {
		//this.books.add(book);
		return this.books;
	}
	
	@PostMapping("/post")
	public Book addBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@GetMapping("/{id}")
	public Book addBook(@PathVariable String id) {
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookId().equals(id)) {
				return books.get(i);
			}
		}
		return books.get(0);
	}
	
}
