package com.piyushcodes.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyushcodes.librarymanagementsystem.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
