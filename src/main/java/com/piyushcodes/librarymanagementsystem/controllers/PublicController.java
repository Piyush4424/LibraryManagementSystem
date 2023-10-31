package com.piyushcodes.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyushcodes.librarymanagementsystem.model.Book;
import com.piyushcodes.librarymanagementsystem.serviceinterf.BookServiceInterf;

@RestController
@RequestMapping(value = "/public/")
public class PublicController {
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@GetMapping(value = "/getbook/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		Book book = this.bookServiceInterf.findBookById(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBook")
	public ResponseEntity<List<Book>> getBook()
	{
		List<Book> books = this.bookServiceInterf.findAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
}
