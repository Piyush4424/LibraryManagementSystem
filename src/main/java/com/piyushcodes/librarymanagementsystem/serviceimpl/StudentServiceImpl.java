package com.piyushcodes.librarymanagementsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushcodes.librarymanagementsystem.model.Student;
import com.piyushcodes.librarymanagementsystem.repository.StudentRepository;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateStudentRequest;
import com.piyushcodes.librarymanagementsystem.serviceinterf.StudentServiceInterf;

@Service
public class StudentServiceImpl implements StudentServiceInterf{
  
	@Autowired
	StudentRepository StudentRepository;
	
	@Override
	public Student findStudentById(int id) {
		Optional<Student> Student = this.StudentRepository.findById(id);
		if(Student.isEmpty())
			throw new EntityNotFoundException("Student with id " + id + " doesn't exists.");
		return Student.get();
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> Students = this.StudentRepository.findAll();
		if(Students.isEmpty())
			throw new EntityNotFoundException("No Student exists in the directory.");
		return Students;
	}

	@Override
	public Student updateStudent(CreateStudentRequest Student, int id) 
	{
		Student existingStudent = findStudentById(id);
        existingStudent.setSName(Student.getName());
        existingStudent.setSEmail(Student.getEmail());
        return saveStudent(Student);
	}

	@Override
	public Student deleteStudent(int id) {
		Student Student = findStudentById(id);
		this.StudentRepository.delete(Student);
		return Student;
	}

	@Override
	public Student saveStudent(CreateStudentRequest Student) {
		return this.StudentRepository.save(Student.toStudent());
	}

}
