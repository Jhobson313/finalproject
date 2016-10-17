<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Goals Dashboard</title>
</head>
<body>
<h1>
	Here's a list of your goal info:
</h1>

<ul>
	<li>Goal 1 <a href="<c:url value="/goaldetails"/>"> Details</a></li>
	<li>Goal 2 <a href="<c:url value="/goaldetails"/>"> Details</a></li>
	<li>Etc...</li>
</ul>

<h4>
	<a href="<c:url value="/deposit-details"/>">Deposit Details</a>
	<a href="<c:url value="/addgoal"/>"> Add A NEW GOAL</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>

</body>
</html>