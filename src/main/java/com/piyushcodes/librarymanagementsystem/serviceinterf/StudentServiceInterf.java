package com.piyushcodes.librarymanagementsystem.serviceinterf;

import java.util.List;

import com.piyushcodes.librarymanagementsystem.model.Student;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateStudentRequest;

public interface StudentServiceInterf {
	Student saveStudent(CreateStudentRequest student);
	Student findStudentById(int id);
    List<Student> findAllStudents();
    Student updateStudent(CreateStudentRequest student, int id);
    Student deleteStudent(int id);
}
