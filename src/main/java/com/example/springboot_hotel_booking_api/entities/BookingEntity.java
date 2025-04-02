package com.example.springboot_hotel_booking_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.example.springboot_hotel_booking_api.enums.BookingStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a hotel booking.
 * This class maps to the "tb_booking" table in the database and 
 * contains information about a booking's check-in, check-out, status, and associated user.
 */
@Entity
@Table(name = "tb_booking")
public class BookingEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
	private Long id;
	private Instant checkIn;
	private Instant checkOut;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id") // Foreign key linking the booking to an user
	private UserEntity client;
	
	@ManyToOne
	@JoinColumn(name = "room_id") // Foreign key linking the booking to a room.
	private RoomEntity room;
	
	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private PaymentEntity payment;
	
	public BookingEntity() {
	}

	public BookingEntity(Long id, Instant checkIn, Instant checkOut, BookingStatus status, UserEntity client,
			RoomEntity room) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
		this.client = client;
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Instant checkIn) {
		this.checkIn = checkIn;
	}

	public Instant getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Instant checkOut) {
		this.checkOut = checkOut;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public UserEntity getClient() {
		return client;
	}

	public void setClient(UserEntity client) {
		this.client = client;
	}
	
	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	
	/**
	 * Calculates the total cost of a booking based on the number of days stayed.
	 * The total price is determined by multiplying the number of days between 
	 * check-in and check-out by the room's price per night.
	 */
	public double getTotal() {
		// Convert check-in and check-out timestamps to LocalDate using the system's default time zone
		LocalDate checkInDate = checkIn.atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate checkOutDate = checkOut.atZone(ZoneId.systemDefault()).toLocalDate();
		
		// Calculate the number of days between check-in and check-out
		long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
		
		// Validate that the check-out date is after the check-in date
		if(days <= 0) {
			throw new IllegalArgumentException("Check-out date must be after check-in.");
		}
		
		// Calculate the total cost based on the number of days and the room's price per night
		return days * room.getPrice();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingEntity other = (BookingEntity) obj;
		return Objects.equals(id, other.id);
	}
}
