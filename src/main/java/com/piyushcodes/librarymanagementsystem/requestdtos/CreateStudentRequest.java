package com.piyushcodes.librarymanagementsystem.requestdtos;

import javax.validation.constraints.NotBlank;

import com.piyushcodes.librarymanagementsystem.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
	
	@NotBlank
    private String name;
	
	@NotBlank
    private String email;
    
    public Student toStudent()
    {
    	return Student.builder()
    	       .sName(name)
    	       .sEmail(email)
    	       .build();
    }
}
