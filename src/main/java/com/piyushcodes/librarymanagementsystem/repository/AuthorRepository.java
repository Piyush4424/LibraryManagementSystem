package com.piyushcodes.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piyushcodes.librarymanagementsystem.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	@Query(value = "SELECT * FROM AUTHOR WHERE name = ?1", nativeQuery = true)
	Author findAuthorByName(String name);
}
