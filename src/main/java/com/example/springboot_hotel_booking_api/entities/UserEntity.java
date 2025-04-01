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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * Represents a User entity in the system.
 * This entity is mapped to the "tb_user" table in the database.
 */
@Entity
@Table(name = "tb_user")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-increment primary key
	private Long id;
	private String name;
	private String email;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private Set<BookingEntity> bookings = new HashSet<>();
	
	//Default constructor required by JPA.
	public UserEntity() {
	}

	//Parameterized constructor for creating a UserEntity instance.
	public UserEntity(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<BookingEntity> getBookings() {
		return bookings;
	}

	/**
     * Generates a hash code based on the user ID.
     * This is useful for collections that rely on hash codes.
     */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
     * Compares this UserEntity with another object for equality.
     * Two users are considered equal if they have the same ID.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}
}
