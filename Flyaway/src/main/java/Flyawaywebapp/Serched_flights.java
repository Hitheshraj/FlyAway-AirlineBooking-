package Flyawaywebapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/Serched_flights")
public class Serched_flights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		session.beginTransaction();
		Query flight_detail = session
				.createQuery("select a.flight_id,a.flight_name,f.Time,f.price from Places p,Flight_path f,AirLine a where p.place_id=f.place and f.airLine=a.flight_id and p.source='"
						+ source + "' and p.desination='" + destination +"'");
		List<Object[]> detail=(List<Object[]>)flight_detail.list();
		session.getTransaction().commit();
		session.close();
		RequestDispatcher dispacther = request.getRequestDispatcher("/Available_flights.jsp");
		request.setAttribute("source", source);
		request.setAttribute("destination", destination);
		request.setAttribute("flight_detail", detail);
		dispacther.forward(request, response);
	}

}
