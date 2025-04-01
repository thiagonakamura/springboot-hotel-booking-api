package com.example.springboot_hotel_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hotel_booking_api.entities.BookingEntity;

/**
 * Repository interface for BookingEntity.
 * 
 * This interface extends JpaRepository, providing built-in CRUD operations
 * for the BookingEntity without requiring explicit implementation.
 */
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

}
