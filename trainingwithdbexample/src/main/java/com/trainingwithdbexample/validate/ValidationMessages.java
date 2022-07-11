package com.trainingwithdbexample.validate;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trainingwithdbexample.controller.StudentController;
import com.trainingwithdbexample.dto.ErrorMessage;
import com.trainingwithdbexample.exception.SyntaxError;

@ControllerAdvice
public class ValidationMessages extends ResponseEntityExceptionHandler{
	private final Logger logger = LogManager.getLogger(ValidationMessages.class);
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleExceptio(EntityNotFoundException ex){
		ErrorMessage validationErrorResponse = new ErrorMessage();
		validationErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		validationErrorResponse.setMessage("Data is not existing in database");
		return new ResponseEntity<>(validationErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SyntaxError.class)
	public ResponseEntity<ErrorMessage> handleExceptio(SyntaxError ex){
		ErrorMessage validationErrorResponse = new ErrorMessage();
		validationErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		validationErrorResponse.setMessage("Table is not updated");
		return new ResponseEntity<>(validationErrorResponse,HttpStatus.NOT_FOUND);
	}

}
