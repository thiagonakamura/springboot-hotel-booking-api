package com.example.springboot_hotel_booking_api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a Hotel entity in the system.
 * This entity is mapped to the "tb_hotel" table in the database.
 */
@Entity
@Table(name = "tb_hotel")
public class HotelEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-increment primary key
	private Long id;
	private String name;
	private String location;
	private Double rating;
	
	@OneToMany(mappedBy = "hotel")
	private Set<RoomEntity> rooms = new HashSet<>();
	
	public HotelEntity() {
	}

	public HotelEntity(Long id, String name, String location, Double rating) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Set<RoomEntity> getRooms() {
		return rooms;
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
		HotelEntity other = (HotelEntity) obj;
		return Objects.equals(id, other.id);
	}
}
