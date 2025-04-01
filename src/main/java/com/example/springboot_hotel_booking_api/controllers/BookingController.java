package com.example.springboot_hotel_booking_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_hotel_booking_api.dtos.BookingRecordDto;
import com.example.springboot_hotel_booking_api.entities.BookingEntity;
import com.example.springboot_hotel_booking_api.entities.UserEntity;
import com.example.springboot_hotel_booking_api.services.BookingService;
import com.example.springboot_hotel_booking_api.services.UserService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing booking-related operations.
 * This controller handles CRUD operations for bookings, including retrieving, creating, updating, and deleting bookings.
 * 
 * The endpoints return appropriate HTTP responses along with booking data.
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	//Retrieves a list of all bookings
	@GetMapping
	public ResponseEntity<List<BookingEntity>> getAllBookings(){
		return ResponseEntity.ok().body(bookingService.getAllBookings());
	}
	
	//Retrieves a single booking by ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookingEntity> getOneBooking(@PathVariable Long id){
		BookingEntity booking = bookingService.getOneBooking(id);
		return ResponseEntity.ok().body(booking);
	}
	
	//Saves a new booking to the system.
	@PostMapping
	public ResponseEntity<BookingEntity> saveBooking(@RequestBody @Valid BookingRecordDto bookingRecordDto){
		var booking = new BookingEntity();
		
		UserEntity user = userService.getOneUser(bookingRecordDto.clientId());
		booking.setCheckIn(bookingRecordDto.checkIn());
		booking.setCheckOut(bookingRecordDto.checkOut());
		booking.setStatus(bookingRecordDto.status());
		booking.setClient(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.saveBooking(booking));
	}
	
	//Updates an existing booking by ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<BookingEntity> updateBooking(@PathVariable Long id,@RequestBody @Valid BookingRecordDto bookingRecordDto){
		BookingEntity booking = bookingService.getOneBooking(id);
		
		UserEntity user = userService.getOneUser(bookingRecordDto.clientId());
		booking.setCheckIn(bookingRecordDto.checkIn());
		booking.setCheckOut(bookingRecordDto.checkOut());
		booking.setStatus(bookingRecordDto.status());
		booking.setClient(user);
		
		return ResponseEntity.ok().body(bookingService.updateBooking(id, booking));
	}
	
	//Deletes a booking by ID.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Long id){
		bookingService.deleteBooking(id);
		return ResponseEntity.ok().body("Booking with id " + id + " deleted.");
	}
}
