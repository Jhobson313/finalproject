
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%--
	This page is the main home screen where the user will be able to login
	go to their google calendar to view upcoming due dates, or navigate to their individual goals detail screen
	
	The following Java classes are used:
	
	- Model: none
	- DAO: none
	- Controller: HomeController
	- MySQL Table: db_dreamsetter
 --%>



<html>
<head>
<%@ include file="head.jsp"%>
</head>
<body>
	<h2>Add A New Goal Here</h2>

	<%@ include file="login_bar.jsp"%>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Dream Setter  
</h1>

<h3>
	*A dream is just a goal without a due date*
</h3>

<P>  The time is ${serverTime}. </P>

<a href="<c:url value="/newuser"/>"><br>Create new account</a>
<%--<a href="<c:url value="https://calendar.google.com/calendar/render#main_7"/>"><br><br>Go to Google Calendar</a>--%>
<a href="<c:url value="/goalsdashboard"/>"><br><br>Goals Dashboard (Temp)</a>

</body>
</html>
