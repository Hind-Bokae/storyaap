package com.example.storyapp.exception;

import com.example.storyapp.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO>handelValidationErrors(
			MethodArgumentNotValidException validException){
		Map<String,String> errors=new HashMap<>();
		
		List<FieldError> fieldErrors=validException.getBindingResult().getFieldErrors();
		for (FieldError fieldError:fieldErrors){
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		ErrorResponseDTO errorRespons= new ErrorResponseDTO();
		errorRespons.setTimestamp(LocalDateTime.now());
		errorRespons.setStatus(HttpStatus.BAD_REQUEST.value());
		errorRespons.setMessage("Validation failed");
		errorRespons.setErrors(errors);
		
		return new ResponseEntity<>(errorRespons, HttpStatus.BAD_REQUEST);
	}
}
