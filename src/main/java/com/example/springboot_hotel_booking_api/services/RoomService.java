package com.example.springboot_hotel_booking_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_hotel_booking_api.entities.RoomEntity;
import com.example.springboot_hotel_booking_api.repositories.RoomRepository;
import com.example.springboot_hotel_booking_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to RoomEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting rooms.
 * It acts as an intermediary between the controller and the repository.
 */
@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	//Retrieves all rooms from the database.
	public List<RoomEntity> getAllRooms(){
		return roomRepository.findAll();
	}
	
	//Retrieves a room by its ID.
	public RoomEntity getOneRoom(Long id) {
		return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new room in the database.
	public RoomEntity saveRoom(RoomEntity room) {
		return roomRepository.save(room);
	}
	
	//Updates an existing room with new data.
	public RoomEntity updateRoom(Long id, RoomEntity room) {
		RoomEntity roomEntity = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(room, roomEntity, "id");
		return roomRepository.save(roomEntity);
	}
	
	//Deletes a room from the database.
	public void deleteRoom(Long id) {
		RoomEntity room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		roomRepository.delete(room);
	}
}
