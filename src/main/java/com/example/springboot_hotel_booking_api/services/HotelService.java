package com.example.springboot_hotel_booking_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_hotel_booking_api.entities.HotelEntity;
import com.example.springboot_hotel_booking_api.repositories.HotelRepository;
import com.example.springboot_hotel_booking_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to HotelEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting hotels.
 * It acts as an intermediary between the controller and the repository.
 */
@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	//Retrieves all hotels from the database.
	public List<HotelEntity> getAllHotels(){
		return hotelRepository.findAll();
	}
	
	//Retrieves a hotel by its ID.
	public HotelEntity getOneHotel(Long id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new hotel in the database.
	public HotelEntity saveHotel(HotelEntity hotel) {
		return hotelRepository.save(hotel);
	}
	
	//Updates an existing hotel with new data.
	public HotelEntity updateHotel(Long id, HotelEntity hotel) {
		HotelEntity hotelEntity = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(hotel, hotelEntity, "id");
		return hotelRepository.save(hotelEntity);
	}
	
	//Deletes a hotel from the database.
	public void deleteHotel(Long id) {
		HotelEntity hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		hotelRepository.delete(hotel);
	}
}
