package com.piyushcodes.librarymanagementsystem.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.piyushcodes.librarymanagementsystem.requestdtos.ErrorResponse;


@Configuration
@RestControllerAdvice
public class CustomExceptionConfig 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
    	BindingResult bindingResult = e.getBindingResult();
    	List<FieldError> fieldErrors = bindingResult.getFieldErrors(); 
    	List<String> errorList = fieldErrors.stream().map(x -> x.getDefaultMessage())
    			.collect(Collectors.toList());
    	
    	ErrorResponse errorResponse = ErrorResponse.builder().message(errorList).status(HttpStatus.NOT_ACCEPTABLE).devMessage(e.getMessage())
    	.errorCode("Err_406").build();
    	
    	return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
}
