package com.piyushcodes.librarymanagementsystem.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piyushcodes.librarymanagementsystem.enums.State;
import com.piyushcodes.librarymanagementsystem.model.Student;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateStudentRequest;
import com.piyushcodes.librarymanagementsystem.serviceinterf.StudentServiceInterf;
import com.piyushcodes.librarymanagementsystem.serviceinterf.TransactionServiceInterf;

@RestController
@RequestMapping(value = "/student/")
public class StudentController
{
	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@Autowired
	TransactionServiceInterf transactionServiceInterf;
	
	@PostMapping(value = "/savestudent")
	public ResponseEntity<Student> saveStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest)
	{
		Student student = this.studentServiceInterf.saveStudent(createStudentRequest);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatestudent")
	public ResponseEntity<?> updateStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest,
			                            @RequestParam("id") int id)
	{
		Student updatedStudent = this.studentServiceInterf.updateStudent(createStudentRequest, id);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	@GetMapping(value = "/libtransaction/{status}")
	public ResponseEntity<?>  libTransaction(@RequestParam("studentId") @NotNull int studentId,
			                  @RequestParam("bookId") int bookId,
			                  @PathVariable("status") @NotBlank State status
			                  )
	{
		String externalId = this.transactionServiceInterf.makeTransaction(bookId,studentId,status);
		return new ResponseEntity<String>(externalId,HttpStatus.OK);
	}
   
}
