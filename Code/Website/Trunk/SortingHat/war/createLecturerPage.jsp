<% //This page will check first to see if there is stored 
//times already chosen by the lecturer. If so, it will
//present statistics on student information
//if not it will present a calendar for the lecturer to choose
//times from %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scheduler</title>
</head>
<body>

<% 
boolean timesNotYetChosen = true;
if (timesNotYetChosen) { 
%>

<form action="/lecturertimes" method="post">
<input name="className" type="text" placeholder="class">

<table border=1>
<tr>
<th></th><th>Monday</th><th>Tuesday</th><th>Wednesday</th><th>Thursday</th><th>Friday</th>
</tr>
<tr>
<td>
9:00
</td>
<td ID="109">
<input name="selection[]" type="checkbox" value="109" class="checkbox">
</td>
<td ID="209">
<input name="selection[]" type="checkbox" value="209"  class="checkbox">
</td>
<td ID="309">
<input name="selection[]" type="checkbox" value="309"  class="checkbox">
</td>
<td ID="409">
<input name="selection[]" type="checkbox" value="409"  class="checkbox">
</td>
<td ID="509">
<input name="selection[]" type="checkbox" value="509"  class="checkbox">
</td>
</tr>
<tr>
<td>
10:00
</td>
<td ID="110">
<input name="selection[]" type="checkbox" value="110"  class="checkbox">
</td>
<td ID="210">
<input name="selection[]" type="checkbox" value="210"  class="checkbox">
</td>
<td ID="310">
<input name="selection[]" type="checkbox" value="310"  class="checkbox">
</td>
<td ID="410">
<input name="selection[]" type="checkbox" value="410"  class="checkbox">
</td>
<td ID="510">
<input name="selection[]" type="checkbox" value="510"  class="checkbox">
</td>

</tr>
<tr>
<td>
11:00
</td>
<td ID="111">
<input name="selection[]" type="checkbox" value="111"  class="checkbox">
</td>
<td ID="211">
<input name="selection[]" type="checkbox" value="211"  class="checkbox">
</td>
<td ID="311">
<input name="selection[]" type="checkbox" value="311"  class="checkbox">
</td>
<td ID="411">
<input name="selection[]" type="checkbox" value="411"  class="checkbox">
</td>
<td ID="511">
<input name="selection[]" type="checkbox" value="511"  class="checkbox">
</td>
</tr>
<tr>
<td>
12:00
</td>
<td ID="112">
<input name="selection[]" type="checkbox" value="112"  class="checkbox">
</td>
<td ID="212">
<input name="selection[]" type="checkbox" value="212"  class="checkbox">
</td>
<td ID="312">
<input name="selection[]" type="checkbox" value="312"  class="checkbox">
</td>
<td ID="412">
<input name="selection[]" type="checkbox" value="412"  class="checkbox">
</td>
<td ID="512">
<input name="selection[]" type="checkbox" value="512"  class="checkbox">
</td> 
</tr>
<tr>
<td>
1:00
</td>
<td ID="113">
<input name="selection[]" type="checkbox" value="113"  class="checkbox">
</td>
<td ID="213">
<input name="selection[]" type="checkbox" value="213"  class="checkbox">
</td>
<td ID="313">
<input name="selection[]" type="checkbox" value="313"  class="checkbox">
</td>
<td ID="413">
<input name="selection[]" type="checkbox" value="413"  class="checkbox">
</td>
<td ID="513">
<input name="selection[]" type="checkbox" value="513"  class="checkbox">
</td> 
</tr>
<tr>
<td>
2:00
</td>
<td ID="114">
<input name="selection[]" type="checkbox" value="114"  class="checkbox">
</td>
<td ID="214">
<input name="selection[]" type="checkbox" value="214"  class="checkbox">
</td>
<td ID="314">
<input name="selection[]" type="checkbox" value="314"  class="checkbox">
</td>
<td ID="414">
<input name="selection[]" type="checkbox" value="414"  class="checkbox">
</td>
<td ID="514">
<input name="selection[]" type="checkbox" value="514"  class="checkbox">
</td> 
</tr>
<tr>
<td>
3:00
</td>
<td ID="115">
<input name="selection[]" type="checkbox" value="115"  class="checkbox">
</td>
<td ID="215">
<input name="selection[]" type="checkbox" value="215"  class="checkbox">
</td>
<td ID="315">
<input name="selection[]" type="checkbox" value="315"  class="checkbox">
</td>
<td ID="415">
<input name="selection[]" type="checkbox" value="415"  class="checkbox">
</td>
<td ID="515">
<input name="selection[]" type="checkbox" value="515"  class="checkbox">
</td> 
</tr>
<tr>
<td>
4:00
</td>
<td ID="116">
<input name="selection[]" type="checkbox" value="116"  class="checkbox">
</td>
<td ID="216">
<input name="selection[]" type="checkbox" value="216"  class="checkbox">
</td>
<td ID="316">
<input name="selection[]" type="checkbox" value="316"  class="checkbox">
</td>
<td ID="416">
<input name="selection[]" type="checkbox" value="416"  class="checkbox">
</td>
<td ID="516">
<input name="selection[]" type="checkbox" value="516"  class="checkbox">
</td> 
</tr>
<tr>
<td>
5:00
</td>
<td ID="117">
<input name="selection[]" type="checkbox" value="117"  class="checkbox">
</td>
<td ID="217">
<input name="selection[]" type="checkbox" value="217"  class="checkbox">
</td>
<td ID="317">
<input name="selection[]" type="checkbox" value="317"  class="checkbox">
</td>
<td ID="417">
<input name="selection[]" type="checkbox" value="417"  class="checkbox">
</td>
<td ID="517">
<input name="selection[]" type="checkbox" value="517" class="checkbox">
</td> 
</tr>

</table>
<input type="submit" name="Submit" value="Submit">
</form>

<%
} else {
//return number of students who have nominated times
%>

<%
}
%>

</body>
</html>