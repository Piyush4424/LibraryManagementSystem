package com.piyushcodes.librarymanagementsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushcodes.librarymanagementsystem.model.Author;
import com.piyushcodes.librarymanagementsystem.repository.AuthorRepository;
import com.piyushcodes.librarymanagementsystem.requestdtos.CreateAuthorRequest;
import com.piyushcodes.librarymanagementsystem.serviceinterf.AuthorServiceInterf;

@Service
public class AuthorServiceImpl implements AuthorServiceInterf {
 
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author findAuthorById(int id) {
		Optional<Author> author = this.authorRepository.findById(id);
		if(author.isEmpty())
			throw new EntityNotFoundException("Author with id " + id + " doesn't exists.");
		return author.get();
	}

	@Override
	public List<Author> findAllAuthors() {
		List<Author> authors = this.authorRepository.findAll();
		if(authors.isEmpty())
			throw new EntityNotFoundException("No Author exists in the directory.");
		return authors;
	}

	@Override
	public Author updateAuthor(CreateAuthorRequest author, int id) 
	{
		Author existingAuthor = findAuthorById(id);
        existingAuthor.setAName(author.getName());
        existingAuthor.setAEmail(author.getEmail());
        return saveAuthor(author);
	}

	@Override
	public Author deleteAuthor(int id) {
		Author author = findAuthorById(id);
		this.authorRepository.delete(author);
		return author;
	}

	@Override
	public Author saveAuthor(CreateAuthorRequest author) {
		return this.authorRepository.save(author.toAuthor());
	}



}
