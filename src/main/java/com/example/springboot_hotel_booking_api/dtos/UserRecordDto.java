package com.example.springboot_hotel_booking_api.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for representing a user in the system.
 * This record is used for transferring user information such as name, email, and password.
 * 
 * The fields are annotated with @NotBlank to ensure that the values for name, email, and password 
 * are not empty or null during validation. 
 * This helps ensure that all user records contain the necessary information for further processing.
 */
public record UserRecordDto(@NotBlank String name, @NotBlank String email, @NotBlank String password) {

}
