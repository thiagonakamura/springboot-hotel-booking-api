package com.example.springboot_hotel_booking_api.dtos;

import java.time.Instant;

import com.example.springboot_hotel_booking_api.enums.BookingStatus;

import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for representing a booking in the system.
 * This record is used for transferring user information such as checkIn, checkOut, status and client id.
 * 
 * The fields are annotated with @NotNull to ensure that the values 
 * are not empty or null during validation. 
 * This helps ensure that all user records contain the necessary information for further processing.
 */
public record BookingRecordDto(@NotNull Instant checkIn, @NotNull Instant checkOut, @NotNull BookingStatus status, @NotNull Long clientId) {

}
