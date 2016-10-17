
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%--
	This page is the main home screen where the user will be able to login
	go to their google calendar to view upcoming due dates, or navigate to their individual goals detail screen
	
	The following Java classes are used:
	
	- Model: none
	- DAO: none
	- Controller: HomeController
	- MySQL Table: db_dreamsetter
 --%>
 
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width,
 initial-scale =1">

<title>DREAMSETTER</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">
	<div class="jumbotron">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="C:/Users/User/Pictures/Dream to reality.jpg" float=right
						height=100px width=1100px alt="Dream Big">
				</div>

				<div class="item">
					<img src="C:/Users/User/Pictures/dreams.jpg" float=center
						height=100px width=1100px alt="Dreams">
				</div>

				<div class="item">
					<img src="C:/Users/User/Pictures/dreams-road-sign.jpg" float=center
						height=100px width=1100px alt="Follow your Dreams">
				</div>

				<div class="item">
					<img src="C:/Users/User/Pictures/Dreams cl.jpg" float=center
						height=100px width=1100px alt="Dream Cloud">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>


		<head>
<title>Home</title>
<%@ include file="login_bar.jsp"%>
<%@ include file="head.jsp"%>
		</head>

		<body>
			<h1>Welcome to DreamSetter</h1>

			<h2>
				Make your Dreams a reality with DREAMSETTER!<br> Track your
				progress and stay motivated to accomplish your goals! <i>*A
					dream is just a goal without a due date*</i>
			</h2>

			<P>The time is ${serverTime}.</P>
			<strong> <a href="<c:url value="/login"/>">LOGIN</a> <a
				href="<c:url value="/newuser"/>"><br>Create new user</a> <a
				href="<c:url value="https://calendar.google.com/calendar/render#main_7"/>"><br>
				<br>Go to Google Calendar</a> <a
				href="<c:url value="/goalsdashboard"/>"><br>
				<br>Goals Dashboard </a></strong>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		</body>
</html>
