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

import com.example.springboot_hotel_booking_api.dtos.RoomRecordDto;
import com.example.springboot_hotel_booking_api.entities.HotelEntity;
import com.example.springboot_hotel_booking_api.entities.RoomEntity;
import com.example.springboot_hotel_booking_api.services.HotelService;
import com.example.springboot_hotel_booking_api.services.RoomService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing room-related operations.
 * This controller handles CRUD operations for rooms, including retrieving, creating, updating, and deleting rooms.
 * 
 * The endpoints return appropriate HTTP responses along with room data.
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HotelService hotelService;
	
	//Retrieves a list of all rooms
	@GetMapping
	public ResponseEntity<List<RoomEntity>> getAllRooms(){
		return ResponseEntity.ok().body(roomService.getAllRooms());
	}
	
	//Retrieves a single room by ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<RoomEntity> getOneRoom(@PathVariable Long id){
		RoomEntity room = roomService.getOneRoom(id);
		return ResponseEntity.ok().body(room);
	}
	
	//Saves a new room to the system.
	@PostMapping
	public ResponseEntity<RoomEntity> saveRoom(@RequestBody @Valid RoomRecordDto roomRecordDto){
		var room = new RoomEntity();
		
		HotelEntity hotel = hotelService.getOneHotel(roomRecordDto.hotelId());
		room.setType(roomRecordDto.type());
		room.setPrice(roomRecordDto.price());
		room.setHotel(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.saveRoom(room));
	}
	
	//Updates an existing room by ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<RoomEntity> updateRoom(@PathVariable Long id,@RequestBody @Valid RoomRecordDto roomRecordDto){
		RoomEntity room = roomService.getOneRoom(id);
		
		HotelEntity hotel = hotelService.getOneHotel(roomRecordDto.hotelId());
		room.setType(roomRecordDto.type());
		room.setPrice(roomRecordDto.price());
		room.setHotel(hotel);
		
		return ResponseEntity.ok().body(roomService.updateRoom(id, room));
	}
	
	//Deletes a room by ID.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable Long id){
		roomService.deleteRoom(id);
		return ResponseEntity.ok().body("Room with id " + id + " deleted.");
	}
}
