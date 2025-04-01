package com.example.springboot_hotel_booking_api.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot_hotel_booking_api.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Global exception handler for handling application-specific exceptions.
 * This class centralizes error handling and ensures consistent responses
 * when exceptions occur in the application.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	//Handles ResourceNotFoundException and returns a standardized error response.
	@ExceptionHandler
	public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resourcce not found";// Error description
		HttpStatus status = HttpStatus.NOT_FOUND;// Sets the HTTP status code
		
		// Creates a standardized error response
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
