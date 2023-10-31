package com.piyushcodes.librarymanagementsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.piyushcodes.librarymanagementsystem.enums.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bId;
	private String bName;
	private Double bPrice;
	
	@Enumerated(EnumType.STRING)
	private Genre bGenre;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties({"books"})
	private Author author;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties({"books"})
	private Student student;
	
//	@ManyToOne
//	@JoinColumn
//	@JsonIgnoreProperties({"books"})
//	private Transaction transaction;
	
	@OneToMany(mappedBy = "book")
	private List<Transaction> transactions;
	
	@CreationTimestamp
	@Column(name = "created")
	private Date DatecreatedOn;
	
	@UpdateTimestamp
	@Column(name = "updated")
	private Date dateUpdatedOn;
}
