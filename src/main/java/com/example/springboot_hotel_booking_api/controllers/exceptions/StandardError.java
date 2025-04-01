package com.example.springboot_hotel_booking_api.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

/**
 * Standardized error response model used across the application.
 * This class encapsulates error details and ensures a uniform error structure in API responses.
 */
public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp; // Timestamp of when the error occurred
	private Integer status;	   // HTTP status code
	private String error;      // Short description of the error
	private String message;    // Detailed error message
	private String path;       // The endpoint where the error occurred
	
	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
