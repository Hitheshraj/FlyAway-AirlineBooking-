package Flyawaywebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Flyawaywebapp.domain.AirLine;
import Flyawaywebapp.domain.Flight_path;
import Flyawaywebapp.domain.Places;
import Flyawaywebapp.domain.User;
import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/BookTickets")
public class BookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id="";String Price = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String flight_name = request.getParameter("flight_name");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String passenger_no=request.getParameter("passener");
		response.setContentType("text/html");
		session.beginTransaction();
		Query flight_detail = session.createQuery(
				"select f.id,a.flight_name,f.Time,f.price from Places p,Flight_path f,AirLine a where p.place_id=f.place and f.airLine=a.flight_id and p.source='"
						+ source + "' and p.desination='" + destination + "' and a.flight_name='" + flight_name
						+ "' and f.Time='" + time + "'");
		List<Object[]> detail = (List<Object[]>) flight_detail.list();
		for (Object[] d : detail) {
			id=d[0].toString();
			Price=d[3].toString();
		}
		session.getTransaction().commit();
		request.getSession().setAttribute("id", id);
		session.close();
		RequestDispatcher dispacther = request.getRequestDispatcher("BookingConfermation.jsp");
		int p=Integer.parseInt(Price);
		int n=Integer.parseInt(passenger_no);
		int total=p*n;
		request.setAttribute("total", total);
		request.getSession().setAttribute("total",total);
		request.setAttribute("destination", destination);
		request.setAttribute("flight_detail", detail);
		request.setAttribute("source", source);
		dispacther.forward(request, response);
	}

}
