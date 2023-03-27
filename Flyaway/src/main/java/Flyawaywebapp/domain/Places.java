package Flyawaywebapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int place_id;
	@Column
	private String source;
	@OneToMany(mappedBy = "place")
	private List<Flight_path> flight_path;
	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}
	@Column
	private String desination;
	public Places() {}
	public Places(String source, String desination) {
		super();
		this.source = source;
		this.desination = desination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDesination() {
		return desination;
	}
	public void setDesination(String desination) {
		this.desination = desination;
	}
	public int getPlace_id() {
		return place_id;
	}
}
