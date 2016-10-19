<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<img alt="Dream Big" src="C:/Users/User/Pictures/dream-big.jpg" height= 250px; width= 1300px><br>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
	On this page we have a form to login with email and password.
	
	Model: none
 --%>

<head>
	<%@ include file="head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/"/>">Home</a>
</div>
<h1>
	Login
</h1>

<c:out value="${ message }"/>
<form method="post" <c:url value="/addgoal"/>>
	<div>
		<label>Email</label>
		<input type="text" name="email"/>
	</div>
	<div>
		<label>Password</label>
		<input type="password" name="password"/>
	</div>
	<button type="submit">Login</button>
</form>

</body>
</html>
