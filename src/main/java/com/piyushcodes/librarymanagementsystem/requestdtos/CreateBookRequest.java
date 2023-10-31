package com.piyushcodes.librarymanagementsystem.requestdtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.piyushcodes.librarymanagementsystem.enums.Genre;
import com.piyushcodes.librarymanagementsystem.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest{
	
	@NotBlank
    private String name;
	
	@NotNull
    private Double price;
	
    private Genre genre;
	
	@NotNull
    private CreateAuthorRequest author;
	
    
    public Book toBook()
    {
    	return Book.builder()
    			   .bName(name)
    			   .bPrice(price)
    			   .bGenre(genre)
    			   .author(author.toAuthor())
    			   .build();
    }
}
