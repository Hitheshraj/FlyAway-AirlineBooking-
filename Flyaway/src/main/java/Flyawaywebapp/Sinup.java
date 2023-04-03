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

import Flyawaywebapp.domain.User;
import Flyawaywebapp.util.HibernateUtil;

@WebServlet("/Sinup")
public class Sinup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Session session = HibernateUtil.getSessionFactory().openSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> userdetail = session
				.createQuery("from User u where u.username='" + username + "'and u.password='" + password + "'").list();
		session.beginTransaction();
		session.getTransaction().commit();
		request.getSession().setAttribute("name", username);
		session.close();

		if (!userdetail.isEmpty()) {
			RequestDispatcher dispacther = request.getRequestDispatcher("/Main.html");
			dispacther.forward(request, response);
		} else {
			RequestDispatcher dispacther = request.getRequestDispatcher("Sinup.html");
			dispacther.forward(request, response);
		}
	}

}
