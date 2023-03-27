package Flyawaywebapp;

public class demo {
private String filght_name;
private String flight_price;
private String flight_time;
public demo() {}
public demo(String filght_name, String flight_price, String flight_time) {
	this.filght_name = filght_name;
	this.flight_price = flight_price;
	this.flight_time = flight_time;
}
public String getFilght_name() {
	return filght_name;
}
public void setFilght_name(String filght_name) {
	this.filght_name = filght_name;
}
public String getFlight_price() {
	return flight_price;
}
public void setFlight_price(String flight_price) {
	this.flight_price = flight_price;
}
public String getFlight_time() {
	return flight_time;
}
public void setFlight_time(String flight_time) {
	this.flight_time = flight_time;
}
}
