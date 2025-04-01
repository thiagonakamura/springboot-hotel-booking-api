package com.example.springboot_hotel_booking_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_hotel_booking_api.entities.BookingEntity;
import com.example.springboot_hotel_booking_api.repositories.BookingRepository;
import com.example.springboot_hotel_booking_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to BookingEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting bookings.
 * It acts as an intermediary between the controller and the repository.
 */
@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	//Retrieves all bookings from the database.
	public List<BookingEntity> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	//Retrieves a booking by its ID.
	public BookingEntity getOneBooking(Long id) {
		return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new booking in the database.
	public BookingEntity saveBooking(BookingEntity booking) {
		return bookingRepository.save(booking);
	}
	
	//Updates an existing booking with new data.
	public BookingEntity updateBooking(Long id, BookingEntity booking) {
		BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(booking, bookingEntity, "id");
		return bookingRepository.save(bookingEntity);
	}
	
	//Deletes a booking from the database.
	public void deleteBooking(Long id) {
		BookingEntity booking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		bookingRepository.delete(booking);
	}
}
