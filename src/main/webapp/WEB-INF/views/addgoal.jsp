<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Add A New Goal</title>
</head>
<body>
<h1>
	Add A New Goal Here
</h1>

<ul>
	<li>Description</li>
	<li>Due Date</li>
	<li>Cost</li>
</ul>

<h4>
	<a href="<c:url value="/goalsdashboard"/>">This Submit button takes you back to the Dashboard</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>

</body>
</html>