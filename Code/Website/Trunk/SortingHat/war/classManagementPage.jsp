<%@ page import="com.wagnerandpei.incubate.ClassTimes;" %>

<% 
//This page will show the class name
//And the lecturer's nominated times
//It will have a link to view the student list
//It will show how many students have nominated times
//And the total number enrolled
//For now it will have a button to sort the class into small groups



String className = (String)request.getParameter("selectClass");
//ClassTimes classinfo = (ClassTimes) session.getAttribute("class");
if (className != null) session.setAttribute("className", className);
else  className = (String)session.getAttribute("className");

//if (classinfo == null) out.print("classinfo = null");
%>

<html>
<head>
<title>
<% //retrieve class name and display it %>
Management
</title>
</head>
<body>
<!-- have a button to call list sort on a class 
have another button to create a new list of students -->
<h1>
<% out.print(className); 
//out.print(classinfo.getLecturerTimes());
%>
</h1>
<form action="/listgenerator" method="post">
<input name="numberOfStudents" type="number">
<input name="submitcreatelist" type="submit" value="New List">
</form>
<form action="/listsort" method="post">
<input name="submitsortlist" type="submit" value="Sort!">
</form>

</body>
</html>