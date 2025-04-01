package com.example.springboot_hotel_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hotel_booking_api.entities.RoomEntity;

/**
 * Repository interface for RoomEntity.
 * 
 * This interface extends JpaRepository, providing built-in CRUD operations
 * for the RoomEntity without requiring explicit implementation.
 */
public interface RoomRepository extends JpaRepository<RoomEntity, Long>{

}
