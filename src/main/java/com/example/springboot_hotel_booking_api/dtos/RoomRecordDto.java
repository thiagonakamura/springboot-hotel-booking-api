package com.example.springboot_hotel_booking_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for representing a room in the system.
 * This record is used for transferring user information such as type, price and hotel id.
 * 
 * The fields are annotated with @NotNull and @NotBlanck to ensure that the values 
 * are not empty or null during validation. 
 * This helps ensure that all room records contain the necessary information for further processing.
 */
public record RoomRecordDto(@NotBlank String type, @NotNull Double price, @NotNull Long hotelId) {

}
