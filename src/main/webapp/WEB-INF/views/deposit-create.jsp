<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>  
     
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	This page will provide a form in order to add a deposit.
	
	In order to create the "Add Deposits screen, the following will be used:
	
	- Model: deposit.java
	- DAO: DepositDaoJdbcImpl.java
	- Controller: DepositController.java
	- MySQL Table: db_dreamsetter
 --%>

<html>
<head>
<%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%@ include file="head.jsp"%>
</head>
<body>
	<h2>Add Deposits Here!</h2>

	<%--<%@ include file="login_bar.jsp"--%>

	<form method="post">
		<div>
			<label>Deposit Amount:</label> <input type="text"
				name="depositAmount" value="${deposit.depositAmount}" />
		</div>
		
		<div>
			<label>Date:</label>
			<input type="date" name="date" value="${deposit.current_date}"/>
		</div>
			
		<button type="submit">Submit</button>
	</form>

	<h4>
		<a href="<c:url value="/goalsdashboard"/>">This Submit button
			takes you back to the Dashboard</a>
			<a href="<c:url value="/deposit-details"/>">This link should take you to the deposit details screen</a>
	</h4>

	<a href="<c:url value="/"/>">HOME</a>
</body>
</html>