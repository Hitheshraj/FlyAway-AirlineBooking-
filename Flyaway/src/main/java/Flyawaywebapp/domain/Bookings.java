package Flyawaywebapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String flightDeatil_id;
	private String user_id;

	public String getBooking_id() {
		return id;
	}

	public void setBooking_id(String booking_id) {
		this.id = booking_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFlightDeatil_id() {
		return flightDeatil_id;
	}

	public void setFlightDeatil_id(String flightDeatil_id) {
		this.flightDeatil_id = flightDeatil_id;
	}

	public Bookings() {
	}

	public Bookings(String flightDeatil_id, String user_id) {
		this.flightDeatil_id = flightDeatil_id;
		this.user_id = user_id;
	}

}
