package Flyawaywebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Flyawaywebapp.domain.Bookings;
import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/ViewBookings")
public class ViewBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String name = request.getSession().getAttribute("name").toString();
		Query flight_detail = session.createQuery(
				"select u.id from User u where u.username='"+name+ "'");
		List<Integer> detail = (List<Integer>) flight_detail.list();
		String user_id=detail.get(0).toString();
		
		Query flight_detail1 = session.createQuery(
				"select b.flightDeatil_id from Bookings b where b.user_id='"+user_id+"'");
		List<Integer> detail1 = (List<Integer>) flight_detail1.list();
		String flightDeatil_id =detail.get(0).toString();
		
		Query Booking_detail = session.createQuery(
				"select f.Time,f.price,a.flight_name,p.source,p.desination from Flight_path f ,Places p,AirLine a where f.id='"
						+ flightDeatil_id + "' and p.place_id=f.place and f.airLine=a.flight_id");
		List<Object[]> Udetail = (List<Object[]>) Booking_detail.list();
		session.getTransaction().commit();
		session.close();
		RequestDispatcher dispacther = request.getRequestDispatcher("/ViewBooking.jsp");
		request.setAttribute("user_name", name);
		request.setAttribute("Booking_detail", Udetail);
		dispacther.forward(request, response);

	}

}
