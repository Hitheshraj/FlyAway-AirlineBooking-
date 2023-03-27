package Flyawaywebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import Flyawaywebapp.domain.AirLine;
import Flyawaywebapp.domain.Flight_path;
import Flyawaywebapp.domain.Places;
import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/demo")
public class AddFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session =HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AirLine airline1_IG=new AirLine("IG001","Indigo");
		AirLine airline2_IG=new AirLine("IG002","Indigo");
		AirLine airline3_IG=new AirLine("IG003","Indigo");
		AirLine airline4_AI=new AirLine("AI001","Air India");
		AirLine airline5_AI=new AirLine("AI002","Air India");
		AirLine airline6_AI=new AirLine("AI003","Air India");
		AirLine airline7_AI=new AirLine("AI004","Air India");
		AirLine airline8_SJ=new AirLine("SJ001","Spice Jet");
		AirLine airline9_SJ=new AirLine("SJ002","Spice Jet");
		Places places1_B=new Places("Bangalore","Mysore");
		Places places2_B=new Places("Bangalore","Mumbai");
		Places places3_B=new Places("Bangalore","Delhi");
		Places places4_B=new Places("Bangalore","Chennni");
		Places places5_B=new Places("Bangalore","Goa");
		Places places6_B=new Places("Bangalore","Gandhinagar");
		Places places1_M=new Places("Mysore","Bangalore");
		Places places2_M=new Places("Mysore","Goa");
		Places places3_M=new Places("Mysore","Mumbai");
		Flight_path flightPath=new Flight_path(places1_B,airline1_IG,"2000","05:00");
		Flight_path flightPath1=new Flight_path(places1_B,airline5_AI,"2000","10:00");
		Flight_path flightPath2=new Flight_path(places1_B,airline1_IG,"2000","18:00");
		Flight_path flightPath3=new Flight_path(places1_B,airline4_AI,"1500","13:00");
		Flight_path flightPath4=new Flight_path(places1_M,airline4_AI,"1500","15:00");
		Flight_path flightPath6=new Flight_path(places1_M,airline8_SJ,"1500","18:00");
		Flight_path flightPath7=new Flight_path(places1_M,airline1_IG,"2000","08:00");
		Flight_path flightPath5=new Flight_path(places1_M,airline1_IG,"2000","21:00");
		Flight_path flightPath8=new Flight_path(places2_B,airline2_IG,"6000","18:00");
		Flight_path flightPath9=new Flight_path(places3_B,airline3_IG,"6500","21:00");
		Flight_path flightPath10=new Flight_path(places3_B,airline9_SJ,"6500","21:00");
		Flight_path flightPath11=new Flight_path(places4_B,airline8_SJ,"50000","21:30");
		Flight_path flightPath12=new Flight_path(places5_B,airline6_AI,"4000","21:00");
		Flight_path flightPath13=new Flight_path(places5_B,airline7_AI,"4000","18:30");
		Flight_path flightPath14=new Flight_path(places6_B,airline1_IG,"4000","06:30");
		session.save(airline1_IG);
		session.save(airline2_IG);
		session.save(airline3_IG);
		session.save(airline4_AI);
		session.save(airline5_AI);
		session.save(airline6_AI);
		session.save(airline7_AI);
		session.save(airline8_SJ);
		session.save(airline9_SJ);
		session.save(places1_B);
		session.save(places2_B);
		session.save(places3_B);
		session.save(places4_B);
		session.save(places5_B);
		session.save(places6_B);
		session.save(places1_M);
		session.save(places2_M);
		session.save(places3_M);
		session.save(flightPath);
		session.save(flightPath1);
		session.save(flightPath2);
		session.save(flightPath3);
		session.save(flightPath4);
		session.save(flightPath5);
		session.save(flightPath6);
		session.save(flightPath7);
		session.save(flightPath8);
		session.save(flightPath9);
		session.save(flightPath10);
		session.save(flightPath11);
		session.save(flightPath12);
		session.save(flightPath13);
		session.save(flightPath14);
		session.getTransaction().commit();
		session.close();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("Added to db");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
