package com.example.springboot_hotel_booking_api.enums;

/**
 * Enum representing the possible statuses of a hotel booking.
 * This is used to track the state of a reservation throughout its lifecycle.
 */
public enum BookingStatus {

	PENDING,        
    CONFIRMED,      
    CHECKED_IN,     
    CHECKED_OUT,    
    CANCELED,       
    NO_SHOW,        
    REFUNDED 
}
