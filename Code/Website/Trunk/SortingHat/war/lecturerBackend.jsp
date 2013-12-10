
<%
	//HttpSession session = request.getSession();
	String ID = (String) session.getAttribute("id");
	//retrieve lecturer class list from datastore by ID

	String[] classes = (String[]) session.getAttribute("classArray");
	//(String[]) session.getAttribute("classes");

	//print class list for this lecturer
%>

<html>
<head>
<title>Lecturer Back-End</title>
</head>
<body>
	<p>
		Lecturer's ID
		<%
		out.print(ID);
	%>
	</p>


	<div>
		
				<%
					//out.print(classes.length);
					if (classes != null) {
						if (classes.length > 0) { %>
							<form action="classManagementPage.jsp" method="post">
							<table>
						<%	for (String className : classes) {
				%>
				<tr>
					<td>
						<%
							out.print(className);
						%>
					</td>
					<td><input id="<%out.print(className);%>" type="radio"
						value="<%out.print(className);%>" name="selectClass"></td>
				</tr>
				<%
					}
				%>
			</table>
			<input name="submit" type="submit" value="Manage Class">
		</form>

	</div>
	<%
		}
		} else {
	%>
	<p>This is where the list of the lecturers classes will appear.
		Each class will appear with a link to manage that class</p>
	<%
		}
	%>


	<a href="createLecturerPage.jsp">create new class</a>





</body>
</html>