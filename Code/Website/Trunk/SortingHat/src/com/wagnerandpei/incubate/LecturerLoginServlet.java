package com.wagnerandpei.incubate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;

import com.googlecode.objectify.ObjectifyService;

import static com.wagnerandpei.incubate.OfyService.ofy;

import java.util.ArrayList;


public class LecturerLoginServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) 
		throws IOException {
		String classes;
		String[] individualClasses;
		ArrayList<String> classesArrayList;
		String [] classArray;
		
		HttpSession session = request.getSession();
		ObjectifyService.register(Lecturer.class);
		
		String ID = request.getParameter("id");
		String password = request.getParameter("password");
		//verify password, possibly hard coded or retrieved from datastore, or 
		//employing google's user authentication service
		//load lecturer's classes from datastore, to populate list on backend
		Lecturer lecturer = ofy().load().type(Lecturer.class).id(ID).now();
		if (lecturer != null) {
			classes = lecturer.getClasses();
			individualClasses = classes.split("\\s+");
			classesArrayList = lecturer.getClassArray();
			classArray = new String [classesArrayList.size()];
			classArray = classesArrayList.toArray(classArray);
			session.setAttribute("classArray", classArray);
			session.setAttribute("classes", individualClasses);
		}
		
		
		
		session.setAttribute("id", ID);
		request.setAttribute("id", ID);
		RequestDispatcher rd = request.getRequestDispatcher("lecturerBackend.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		}
		}
		

}
