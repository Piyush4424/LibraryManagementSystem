package com.piyushcodes.librarymanagementsystem.serviceinterf;

import java.util.List;

import com.piyushcodes.librarymanagementsystem.model.Book;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateBookRequest;

public interface BookServiceInterf {
	Book saveBook(CreateBookRequest book);
    Book findBookById(int id);
    List<Book> findAllBooks();
    Book updateBook(CreateBookRequest book, int id);
    Book deleteBook(int id);
}
