package com.piyushcodes.librarymanagementsystem.serviceinterf;

import java.util.List;

import com.piyushcodes.librarymanagementsystem.model.Author;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateAuthorRequest;

public interface AuthorServiceInterf {
	Author saveAuthor(CreateAuthorRequest author);
	Author findAuthorById(int id);
    List<Author> findAllAuthors();
    Author updateAuthor(CreateAuthorRequest author, int id);
    Author deleteAuthor(int id);
}
