package com.example.springboot_hotel_booking_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for representing a hotel in the system.
 * This record is used for transferring hotel information such as name, email, and password.
 * 
 * The fields are annotated with @NotBlank and @NotNull to ensure that the values for name, location, and rating
 * are not empty or null during validation. 
 * This helps ensure that all hotel records contain the necessary information for further processing.
 */
public record HotelRecordDto(@NotBlank String name, @NotBlank String location, @NotNull Double rating) {

}
