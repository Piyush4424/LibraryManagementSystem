package com.piyushcodes.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyushcodes.librarymanagementsystem.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
