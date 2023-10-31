package com.piyushcodes.librarymanagementsystem.exceptions;

public class TransactionServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
    public TransactionServiceException(String message)
    {
    	super(message);
    }
}
