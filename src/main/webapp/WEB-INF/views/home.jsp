<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Dream Setter  
</h1>

<h3>
	*Set your dreams*
</h3>

<P>  The time is ${serverTime}. </P>

<a href="<c:url value="/login"/>">LOGIN</a>
<a href="<c:url value="/newuser"/>"><br>Create new user</a>
<a href="<c:url value="https://calendar.google.com/calendar/render#main_7"/>"><br><br>Go to Google Calendar</a>
<a href="<c:url value="/goalsdashboard"/>"><br><br>Goals Dashboard (Temp)</a>

</body>
</html>
