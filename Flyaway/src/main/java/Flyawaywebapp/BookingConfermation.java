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
import Flyawaywebapp.domain.User;
import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/BookingConfermation")
public class BookingConfermation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name=request.getSession().getAttribute("name").toString();
		String flightDeatil_id=request.getSession().getAttribute("id").toString();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query flight_detail = session.createQuery(
				"select u.id from User u where u.username='"+name+ "'");
		List<Integer> detail = (List<Integer>) flight_detail.list();
		String user_id=detail.get(0).toString();	
		System.out.println(user_id);
		System.out.println(flightDeatil_id);
		Bookings book=new Bookings(flightDeatil_id, user_id);
		session.save(book);
		session.getTransaction().commit();
		session.close();
		RequestDispatcher dispacther = request.getRequestDispatcher("/PaymentConfermation.html");
		dispacther.forward(request, response);
		
	}

}
