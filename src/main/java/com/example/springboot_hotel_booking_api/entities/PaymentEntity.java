package com.example.springboot_hotel_booking_api.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity representing a payment for a booking.
 * This class maps to the "tb_payment" table in the database and stores information 
 * about payments related to hotel bookings.
 */
@Entity
@Table(name = "tb_payment")
public class PaymentEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
	private Long id;
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private BookingEntity booking;
	
	public PaymentEntity() {
	}

	public PaymentEntity(Long id, Instant moment, BookingEntity booking) {
		super();
		this.id = id;
		this.moment = moment;
		this.booking = booking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
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
		PaymentEntity other = (PaymentEntity) obj;
		return Objects.equals(id, other.id);
	}
}
