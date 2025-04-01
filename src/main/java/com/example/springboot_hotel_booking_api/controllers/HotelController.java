package com.example.springboot_hotel_booking_api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.example.springboot_hotel_booking_api.dtos.HotelRecordDto;
import com.example.springboot_hotel_booking_api.entities.HotelEntity;
import com.example.springboot_hotel_booking_api.services.HotelService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing hotel-related operations.
 * This controller handles CRUD operations for hotels, including retrieving, creating, updating, and deleting hotels.
 * 
 * The endpoints return appropriate HTTP responses along with hotel data.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	//Retrieves a list of all hotels
	@GetMapping
	public ResponseEntity<List<HotelEntity>> getAllHotels(){
		return ResponseEntity.ok().body(hotelService.getAllHotels());
	}
	
	//Retrieves a single hotel by ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<HotelEntity> getOneHotel(@PathVariable Long id){
		HotelEntity hotel = hotelService.getOneHotel(id);
		return ResponseEntity.ok().body(hotel);
	}
	
	//Saves a new hotel to the system.
	@PostMapping
	public ResponseEntity<HotelEntity> saveHotel(@RequestBody @Valid HotelRecordDto hotelRecordDto){
		var hotel = new HotelEntity();
		BeanUtils.copyProperties(hotelRecordDto, hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
	}
	
	//Updates an existing hotel by ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<HotelEntity> updateHotel(@PathVariable Long id,@RequestBody @Valid HotelRecordDto hotelRecordDto){
		HotelEntity hotel = hotelService.getOneHotel(id);
		BeanUtils.copyProperties(hotelRecordDto, hotel);
		return ResponseEntity.ok().body(hotelService.updateHotel(id, hotel));
	}
	
	//Deletes a hotel by ID.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable Long id){
		hotelService.deleteHotel(id);
		return ResponseEntity.ok().body("Hotel with id " + id + " deleted.");
	}
}
