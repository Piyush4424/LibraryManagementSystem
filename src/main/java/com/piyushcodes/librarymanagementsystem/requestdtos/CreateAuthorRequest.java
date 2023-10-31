package com.piyushcodes.librarymanagementsystem.requestdtos;

import javax.validation.constraints.NotBlank;

import com.piyushcodes.librarymanagementsystem.model.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorRequest {
	
	@NotBlank
    private String name;
	
	@NotBlank
    private String email;
    
    public Author toAuthor()
    {
    	return Author.builder()
    			     .aName(name)
    			     .aEmail(email)
    			     .build();
    }
    
}

