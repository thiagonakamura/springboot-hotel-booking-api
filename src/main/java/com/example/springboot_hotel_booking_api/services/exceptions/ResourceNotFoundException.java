package com.example.springboot_hotel_booking_api.services.exceptions;

/**
 * Custom exception class to handle cases where a requested resource is not found.
 * This exception is thrown when a resource with a specific identifier cannot be located.
 * 
 * The exception message includes the ID of the resource that was not found to provide
 * clearer context for debugging and error handling.
 */
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found with id: " + id);
	}
}
