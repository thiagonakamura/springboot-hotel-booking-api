package com.example.springboot_hotel_booking_api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springboot_hotel_booking_api.entities.BookingEntity;
import com.example.springboot_hotel_booking_api.entities.HotelEntity;
import com.example.springboot_hotel_booking_api.entities.RoomEntity;
import com.example.springboot_hotel_booking_api.entities.UserEntity;
import com.example.springboot_hotel_booking_api.enums.BookingStatus;
import com.example.springboot_hotel_booking_api.repositories.BookingRepository;
import com.example.springboot_hotel_booking_api.repositories.HotelRepository;
import com.example.springboot_hotel_booking_api.repositories.RoomRepository;
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
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	//Method executed when the application starts.
	@Override
	public void run(String... args) throws Exception {
		
		UserEntity u1 = new UserEntity(null, "John Payne", "john@email.com", "j2025.");
		UserEntity u2 = new UserEntity(null, "Cameron Bennet", "cam@email.com", "cam123.");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		HotelEntity h1 = new HotelEntity(null, "Penny Hotel", "Rua Camila Lourdes, 987", 4.7);
		HotelEntity h2 = new HotelEntity(null, "Milan Hotel", "Porta Romana 43", 4.9);
		
		hotelRepository.saveAll(Arrays.asList(h1, h2));
		
		RoomEntity r1 = new RoomEntity(null, "2 bedrooms", 100.0, h2);
		RoomEntity r2 = new RoomEntity(null, "1 bedroom", 60.0, h2);
		
		roomRepository.saveAll(Arrays.asList(r1, r2));
		
		BookingEntity b1 = new BookingEntity(null, Instant.parse("2025-04-04T15:00:00Z"), Instant.parse("2025-04-10T10:00:00Z"), BookingStatus.CONFIRMED, u2, r1);
		BookingEntity b2 = new BookingEntity(null, Instant.parse("2025-04-24T15:00:00Z"), Instant.parse("2025-04-26T10:00:00Z"), BookingStatus.PENDING, u1, r2);
		
		bookingRepository.saveAll(Arrays.asList(b1, b2));
	}

}
