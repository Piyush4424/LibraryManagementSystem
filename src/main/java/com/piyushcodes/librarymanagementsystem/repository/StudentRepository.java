package com.piyushcodes.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyushcodes.librarymanagementsystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
