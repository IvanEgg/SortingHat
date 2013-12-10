package com.wagnerandpei.incubate;

import static com.wagnerandpei.incubate.OfyService.ofy;

import com.googlecode.objectify.*;

import java.io.IOException;

import javax.servlet.http.*;

import com.googlecode.objectify.ObjectifyService;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;

@SuppressWarnings("serial")
public class SchedulingSystemServlet extends HttpServlet {
	private String nameOfCourse = "";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		//get lecturer times from datastore
		//eventually, id will be entered by student in previous page
		this.nameOfCourse = (String) request.getParameter("className");
		//response.getWriter().println(className);
		ClassTimes times = ofy().load().type(ClassTimes.class).id(this.nameOfCourse).now();
		
		//create variable with lecturer times
		String lecturerTimes = times.getLecturerTimes();
		String [] separateTimes = lecturerTimes.split(" ");
		ArrayList<Integer> intTimes = new ArrayList();
		
		for (String time : separateTimes) {
			Integer intTime = Integer.valueOf(time);
			intTimes.add(intTime);
		}
		Integer [] integerTimes = new Integer [intTimes.size()];
		
		for (int i = 0; i < intTimes.size(); i++) {
			integerTimes[i] = intTimes.get(i);

			//response.getWriter().println(integerTimes[i]);
		}
		
		//send data to jsp
		request.setAttribute("lecturerTimes", integerTimes);
		//get servlet context?
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = request.getRequestDispatcher("createStudentPage.jsp"); 
		
		
		//response.setContentType("text/plain");
		//response.getWriter().println("Hello, world");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		}
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		ObjectifyService.register(ClassTimes.class);
		ObjectifyService.register(Lecturer.class);
		
		//String className = request.getParameter("className");
		ClassTimes classRecord = ofy().load().type(ClassTimes.class).id(this.nameOfCourse).now();
				
		String studentNumber = request.getParameter("studentNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String [] times = request.getParameterValues("selection[]");
		
		String studentDetails = studentNumber + " " + firstName + " " + lastName
				+ " ";
		for (String time : times) studentDetails += (time + " ");
		
		studentDetails += "\n";
		classRecord.addStudent(studentDetails);
		ofy().save().entity(classRecord).now();
		
		//go to thank you page
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = request.getRequestDispatcher("thankYou.jsp");
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		}
		//response.setContentType("text/plain");
		//response.getWriter().println(studentNumber);
		//response.getWriter().println(firstName);
		//response.getWriter().println(lastName);

		//get current classTimes object, especially students string
		//add current student details to end of student string
		
	}
}
