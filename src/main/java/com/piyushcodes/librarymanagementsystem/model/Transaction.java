package com.piyushcodes.librarymanagementsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.piyushcodes.librarymanagementsystem.enums.State;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Transaction {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int tId;
	private String tExternalId;
	
	@Enumerated(EnumType.STRING)
	private State tState;
	 
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties({"transactions"})
	private Book book;
	 
	@CreationTimestamp
	private Date createdOn;
}
