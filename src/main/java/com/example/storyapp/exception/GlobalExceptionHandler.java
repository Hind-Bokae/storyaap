package com.example.storyapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,String>> handelValidationErrors(
			MethodArgumentNotValidException validException){
		Map<String,String> errors=new HashMap<>();
		List<FieldError> fieldErrors=validException.getBindingResult().getFieldErrors();
		for (FieldError fieldError:fieldErrors){
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
