package com.wagnerandpei.incubate;

import static com.wagnerandpei.incubate.OfyService.ofy;

//import com.google.common.base.Function;
//import com.googlecode.objectify.*;
import java.io.IOException;

import javax.servlet.http.*;
//import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.googlecode.objectify.ObjectifyService;

import java.util.ArrayList;

public class LecturerTimesServlet extends HttpServlet {
	public void doPost (HttpServletRequest request, 
			HttpServletResponse response )throws IOException {
		ArrayList<String> classArrayList;
		String [] classArray;
		
		ObjectifyService.register(Lecturer.class);
		
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("id");
		String className = request.getParameter("className");
		String [] times = request.getParameterValues("selection[]");
		String allTimes = "";
		for (String time: times) { 
			allTimes += time + " ";
		}
		ClassTimes newClass = new ClassTimes(className, allTimes, ID );
		ofy().save().entity(newClass).now();
		
		//check if lecturer exists in database, if so add class
		Lecturer lecturer = ofy().load().type(Lecturer.class).id(ID).now();

		if (lecturer != null) {
			lecturer.addClass(className);
			classArrayList = lecturer.getClassArray();
			classArray = new String [classArrayList.size()];
			classArray = classArrayList.toArray(classArray);
			session.setAttribute("classArray", classArray);
		}
		//if not, create lecturer
		else lecturer = new Lecturer (ID, className);
		
		//String classes = lecturer.getClasses();
		//String [] individualClasses = classes.split("\\s+");
		
		
		//save lecturer		
		ofy().save().entity(lecturer).now();
		
		//request.setAttribute("classes", individualClasses);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("lecturerBackend.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		}
	}

}
