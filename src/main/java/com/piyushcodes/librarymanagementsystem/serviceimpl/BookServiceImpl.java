package com.piyushcodes.librarymanagementsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piyushcodes.librarymanagementsystem.model.Author;
import com.piyushcodes.librarymanagementsystem.model.Book;
import com.piyushcodes.librarymanagementsystem.repository.AuthorRepository;
import com.piyushcodes.librarymanagementsystem.repository.BookRepository;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateAuthorRequest;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateBookRequest;
import com.piyushcodes.librarymanagementsystem.serviceinterf.BookServiceInterf;

@Service
public class BookServiceImpl implements BookServiceInterf{
	
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	    
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Book findBookById(int id) {
		Optional<Book> book = this.bookRepository.findById(id);
		if(book.isEmpty())
			throw new EntityNotFoundException("Book with id " + id + " doesn't exists.");
		return book.get();
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books = this.bookRepository.findAll();
		if(books.isEmpty())
			throw new EntityNotFoundException("No Book exists in the directory.");
		return books;
	}

	@Override
	public Book updateBook(CreateBookRequest book, int id) 
	{
		Author author = book.getAuthor().toAuthor();
		Author existingAuthor = this.authorRepository.findAuthorByName(author.getAName());
		if(existingAuthor != null)
		{
			author = existingAuthor;
		}
		else 
		{
			this.authorRepository.save(author);
		}
		
        Book existingBook = findBookById(id);
        existingBook.setBName(book.getName());
        existingBook.setBPrice(book.getPrice());
        existingBook.setBGenre(book.getGenre());
        existingBook.setAuthor(author);
        return saveBook(book);
	}

	@Override
	public Book deleteBook(int id) {
		Book book = findBookById(id);
		this.bookRepository.delete(book);
		return book;
	}

	@Override
	@Transactional
	public Book saveBook(CreateBookRequest book) {
		Author author = book.getAuthor().toAuthor();
//		logger.info("author " + author);
		
		Book savedBook = book.toBook();
		savedBook.setAuthor(author);
		this.authorRepository.save(author);
        return this.bookRepository.save(savedBook);
	}

}
