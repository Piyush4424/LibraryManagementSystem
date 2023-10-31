package com.piyushcodes.librarymanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;
	private String aName;
	private String aEmail;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
	
	@ManyToOne
	@JoinColumn
    @JsonIgnoreProperties({"authors"})
	private Student student;
	
	@CreationTimestamp
	@Column(name = "created")
	private Date DatecreatedOn;
	
	@UpdateTimestamp
	@Column(name = "updated")
	private Date dateUpdatedOn;
	
}
