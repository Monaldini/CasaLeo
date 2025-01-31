package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String customerLastname;
	@Column(nullable = false, unique = true)
	private String phoneNumber;
	@Column(nullable = false)
	private int seats;
	@Column(nullable = false)
	private LocalDateTime reservationTime;

	public Reservations() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLastname() {
		return customerLastname;
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public LocalDateTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalDateTime reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Reservations(int id, String customerName, String customerLastname, String phoneNumber, int seats,
			LocalDateTime reservationTime) {

		this.id = id;
		this.customerName = customerName;
		this.customerLastname = customerLastname;
		this.phoneNumber = phoneNumber;
		this.seats = seats;
		this.reservationTime = reservationTime;
	}

}
