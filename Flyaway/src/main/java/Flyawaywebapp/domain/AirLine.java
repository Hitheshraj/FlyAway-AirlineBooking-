package Flyawaywebapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AirLine {
	@Id
	private String flight_id;
	@Column
	private String flight_name;
	@OneToMany(mappedBy = "airLine")
	private List<Flight_path> flight_path;
	public AirLine() {}
	public AirLine(String flight_id,String flight_name) {
		this.flight_id=flight_id;
		this.flight_name = flight_name;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

}
