package com.wagnerandpei.incubate;

import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SuppressWarnings("serial")
public class InitialStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		String data = request.getParameter("className");
		response.getWriter().println("Got it in InitialStudentServlet " + data );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException 
	{
		response.getWriter().println("got it in the doPost method");
		//String className = (String)request.getAttribute("className");
		//String contextPath = request.getContextPath();
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/createStudentPage.jsp");
		//might need to put class name in the response in order to pass it to 
		//createStudentPage.jsp and then on to the SchedulingSystemServlet
		
		try {
		rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		}
		//Another approach I could use is to chain this servlet directly to the 
		//Scheduling System servlet and then call the createStudentPage.jsp
		//from there
	}

}
