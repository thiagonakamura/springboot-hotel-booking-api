package com.example.springboot_hotel_booking_api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springboot_hotel_booking_api.entities.UserEntity;
import com.example.springboot_hotel_booking_api.repositories.UserRepository;

/**
 * Configuration class for test profile initialization.
 * This class is executed when the application starts with the "test" profile active.
 * It populates the database with sample user data for testing purposes.
 */
@Configuration
@Profile("test")// This ensures that the configuration is only active when the "test" profile is used.
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	//Method executed when the application starts.
	@Override
	public void run(String... args) throws Exception {
		
		UserEntity u1 = new UserEntity(null, "John Payne", "john@email.com", "j2025.");
		UserEntity u2 = new UserEntity(null, "Cameron Bennet", "cam@email.com", "cam123.");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
