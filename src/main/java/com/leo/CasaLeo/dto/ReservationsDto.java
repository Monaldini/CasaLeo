package com.leo.CasaLeo.dto;

import java.time.LocalDateTime;

public class ReservationsDto {
	private int id_reservations;
	private String customerName;
	private String customerLatsname;
	private String phoneNumber;
	private LocalDateTime reservationTime;
	public int getId_reservations() {
		return id_reservations;
	}
	public void setId_reservations(int id_reservations) {
		this.id_reservations = id_reservations;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerLatsname() {
		return customerLatsname;
	}
	public void setCustomerLatsname(String customerLatsname) {
		this.customerLatsname = customerLatsname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDateTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalDateTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	
	

}
