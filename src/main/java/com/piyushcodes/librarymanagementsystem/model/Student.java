package com.piyushcodes.librarymanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int sId;
     private String sName;
     private String sEmail;
     
     @OneToMany(mappedBy = "student")
     private List<Book> books;
     
     @OneToMany(mappedBy = "student")
     private List<Author> authors;
     
    @CreationTimestamp
 	@Column(name = "created")
 	private Date DatecreatedOn;
 	
 	@UpdateTimestamp
 	@Column(name = "updated")
 	private Date dateUpdatedOn;
   
}
