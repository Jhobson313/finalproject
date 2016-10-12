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
	*Set your dreams bruh*
</h3>

<P>  The time is ${serverTime} now get off me. </P>

<a href="<c:url value="/login"/>">LOGIN</a>
<a href="<c:url value="/login"/>"><br>Create new user</a>
<a href="<c:url value="https://calendar.google.com/calendar/render#main_7"/>"><br><br>Go to Google Calendar</a>

</body>
</html>
