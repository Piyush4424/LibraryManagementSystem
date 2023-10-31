package com.piyushcodes.librarymanagementsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piyushcodes.librarymanagementsystem.model.Book;
import com.piyushcodes.librarymanagementsystem.model.Student;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateBookRequest;
import com.piyushcodes.librarymanagementsystem.serviceinterf.BookServiceInterf;
import com.piyushcodes.librarymanagementsystem.serviceinterf.StudentServiceInterf;

@RestController
@RequestMapping(value = "/admin/")
public class AdminController {
    @Autowired
    BookServiceInterf bookServiceInterf;
    
    @Autowired
    StudentServiceInterf studentServiceInterf;

// Book controllers
    
	@PostMapping(value = "/savebook")
	public ResponseEntity<Book> saveBook(@RequestBody @Valid CreateBookRequest createBookRequest)
	{
		Book book = this.bookServiceInterf.saveBook(createBookRequest);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatebook")
	public ResponseEntity<?> updateBook(@RequestBody @Valid CreateBookRequest createBookRequest,
			                            @RequestParam("id") int id)
	{
		Book updatedBook = this.bookServiceInterf.updateBook(createBookRequest, id);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletebook/{id}")
	public ResponseEntity<?> deleteBook(@RequestParam("id") int id)
	{
		Book book = this.bookServiceInterf.deleteBook(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
// Student controllers
	
	@GetMapping(value = "/getstudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id)
	{
		Student student = this.studentServiceInterf.findStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getStudent")
	public ResponseEntity<List<Student>> getStudent()
	{
		List<Student> students = this.studentServiceInterf.findAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletestudent/{id}")
	public ResponseEntity<?> deleteStudent(@RequestParam("id") int id)
	{
		Student student = this.studentServiceInterf.deleteStudent(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
