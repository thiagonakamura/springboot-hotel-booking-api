package com.example.springboot_hotel_booking_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hotel_booking_api.entities.UserEntity;

/**
 * Repository interface for UserEntity.
 * 
 * This interface extends JpaRepository, providing built-in CRUD operations
 * for the UserEntity without requiring explicit implementation.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
