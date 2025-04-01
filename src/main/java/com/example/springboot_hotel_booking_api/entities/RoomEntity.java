package com.example.springboot_hotel_booking_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity representing a hotel room.
 * This class maps to the "tb_room" table in the database and stores information about 
 * different types of rooms available in a hotel.
 */
@Entity
@Table(name = "tb_room")
public class RoomEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
	private Long id;
	private String type;
	private Double price;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "hotel_id") // Foreign key linking the room to a hotel
	private HotelEntity hotel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "room") // One-to-Many relationship with bookings
	private Set<BookingEntity> bookings = new HashSet<>();
	
	public RoomEntity() {
	}

	public RoomEntity(Long id, String type, Double price, HotelEntity hotel) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public Set<BookingEntity> getBookings() {
		return bookings;
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
		RoomEntity other = (RoomEntity) obj;
		return Objects.equals(id, other.id);
	}
}
