<%//This file will read in the lecturer's selected times
//and populate a calendar with checkboxes enabled for those times
//it will need a new process method for the form
//also, it should display a please wait message if the lecturer
//has not yet nominated any times%>

<%
boolean lecturerHasNominatedTimes = false;

%>

<!-- This is unecessary as control passes to this page from the schedulingsystem jsp:include page="/schedulingsystem" /-->
<html>
<head>
<title>Scheduler</title>
</head>
<body>


<%
Integer [] times = (Integer []) request.getAttribute("lecturerTimes");
if (times.length > 0) lecturerHasNominatedTimes = true;

if (lecturerHasNominatedTimes) {
%>

<div><p id="intro">Welcome!</p></div>
<div ID="Calendar">
<form action="/schedulingsystem" method="post">
<input name="studentNumber" type="text" placeholder="Student Number">
<input name="firstName" type="text" placeholder="First Name">
<input name="lastName" type="text" placeholder="Last Name">

<table border=1>
<tr>
<th></th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th>
</tr>

<%
for (int i = 9; i<18; i++) {
%>

<tr>
<td>
<% out.print(i); %>:00
</td>
<%
for (int j = 100; j < 501; j = j + 100) {
	int k = i + j;
%>
<td id="

<%
out.print(k);
%>

">
<input name="selection[]" type="checkbox" value="

<%
out.print(k);
%>

<%
boolean timeSelectedByLecturer = false;
//this will test for an array match
for (Integer time : times) {
	if (time == k) timeSelectedByLecturer = true;
}
if (timeSelectedByLecturer) {
%>

">
</td>

<%
} else {
%>
"disabled>
</td>

<%
}
%>


<%
}
%>

</tr>

<%
}
%>

</table>
<input type="submit" name="Submit" value="Submit">
</form>
</div>

<%
		} else {
%>

<p>The lecturer has not yet nominated their available times.
Please check back again soon.</p>

<% } %>

<div ID="Message"></div>
</body>
</html>