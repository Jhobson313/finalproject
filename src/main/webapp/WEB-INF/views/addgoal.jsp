<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
	This page will provide a form in order to add a goal.
	
	In order to create the "Add Goals" screen, the following will be used:
	
	- Model: Goal.java
	- DAO: GoalDaoJdbcImpl.java
	- Controller: AddGoalController.java
	- MySQL Table: db_dreamsetter
 --%>


<html>
<head>
<%@ include file="head.jsp"%>
</head>
<body>
	<h2>Add A New Goal Here</h2>

	<%@ include file="login_bar.jsp"%>

	<form method="post">
		<div>
			<label>Goal Description:</label> <input type="text"
				name="description" value="${goals.description}" />
		</div>
		
		<div>
			<label>Start Date:</label>
			<%-- <input type="date" name="start_date" value="${.category}"/> Will have to pull default current date from library--%>
		</div>
		
		<div>
			<label>Due Date:</label> <input type="date" name="due_date"
				value="${goals.due_date}" />
		</div>
		
		<div>
			<label>available funds:</label> <input type="number" name="funds"
				value="${goals.funds}" />
		</div>
		
		<div>
			<label>goal amount:</label> <input type="number" name ="amount"
				value="${goals.amount}" />
		</div>
		
		<button type="submit">Submit</button>
	</form>

	<h4>
		<a href="<c:url value="/goalsdashboard"/>">This Submit button
			takes you back to the Dashboard</a>
	</h4>

	<a href="<c:url value="/"/>">HOME</a>

</body>
</html>