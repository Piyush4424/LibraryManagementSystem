package com.piyushcodes.librarymanagementsystem.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushcodes.librarymanagementsystem.enums.State;
import com.piyushcodes.librarymanagementsystem.exceptions.TransactionServiceException;
import com.piyushcodes.librarymanagementsystem.model.Author;
import com.piyushcodes.librarymanagementsystem.model.Book;
import com.piyushcodes.librarymanagementsystem.model.Student;
import com.piyushcodes.librarymanagementsystem.model.Transaction;
import com.piyushcodes.librarymanagementsystem.repository.AuthorRepository;
import com.piyushcodes.librarymanagementsystem.repository.BookRepository;
import com.piyushcodes.librarymanagementsystem.repository.TransactionRepository;
import com.piyushcodes.librarymanagementsystem.serviceinterf.BookServiceInterf;
import com.piyushcodes.librarymanagementsystem.serviceinterf.StudentServiceInterf;
import com.piyushcodes.librarymanagementsystem.serviceinterf.TransactionServiceInterf;

@Service
public class TransactionServiceImpl implements TransactionServiceInterf{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public String makeTransaction(int bookId,int studentId, State state) {
		Book book = this.bookServiceInterf.findBookById(bookId);
		if(book == null)
			throw new TransactionServiceException("No Book with id : " + bookId + " exists in the database");
		Student student = this.studentServiceInterf.findStudentById(studentId);
		if(student == null)
			throw new TransactionServiceException("No Student with id : " + studentId + " exists in the database");
		if(state.equals(State.ISSUED) == true)
		{
			Student studentCheck = book.getStudent();
			if(studentCheck != null)
				throw new TransactionServiceException("The requested book is unavailable");
			String externalId = UUID.randomUUID().toString();
			Transaction transaction = Transaction.builder()
					                  .tExternalId(externalId)
					                  .tState(state)
					                  .book(book)
					                  .build();
			this.transactionRepository.save(transaction);
			book.setStudent(student);
			Author author = book.getAuthor();
			author.setStudent(student);
			this.authorRepository.save(author);
			this.bookRepository.save(book);
			return externalId;
		}
		else if(state.equals(State.RETURNED) == true)
		{
			Student studentCheck = book.getStudent();
			if(studentCheck == null)
			{
				throw new TransactionServiceException("The requested book is never issued.");
			}
			String externalId = UUID.randomUUID().toString();
			Transaction transaction = Transaction.builder()
	                                             .tExternalId(externalId)
	                                             .tState(state)
	                                             .book(book)
	                                             .build();
			this.transactionRepository.save(transaction);
			book.setStudent(null);
			Author author = book.getAuthor();
			author.setStudent(null);
			this.authorRepository.save(author);
			this.bookRepository.save(book);
			return externalId;
		}
		else
		{
			throw new TransactionServiceException("Not a valid transaction type.");
		}
	}

}
