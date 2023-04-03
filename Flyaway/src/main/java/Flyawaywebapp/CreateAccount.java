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

import Flyawaywebapp.domain.User;
import Flyawaywebapp.util.HibernateUtil;


@WebServlet("/Login")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session =HibernateUtil.getSessionFactory().openSession();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User(email,username,password);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		RequestDispatcher dispacther=request.getRequestDispatcher("/Sinup.html");
		String welcomemessage = "Welcome to Flyaway" + username + " !!";
		request.setAttribute("message", welcomemessage);
		dispacther.include(request, response);
		/*List<User> users=session.createQuery("from User").list();
		request.setAttribute("User_list", users);
		RequestDispatcher dispacther=request.getRequestDispatcher("/view_Users.jsp");
		dispacther.forward(request, response);*/
	}

}
