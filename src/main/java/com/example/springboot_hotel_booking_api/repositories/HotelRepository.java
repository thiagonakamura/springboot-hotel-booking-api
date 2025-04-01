package com.example.springboot_hotel_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hotel_booking_api.entities.HotelEntity;

/**
 * Repository interface for HotelEntity.
 * 
 * This interface extends JpaRepository, providing built-in CRUD operations
 * for the HotelEntity without requiring explicit implementation.
 */
public interface HotelRepository extends JpaRepository<HotelEntity, Long>{

}
