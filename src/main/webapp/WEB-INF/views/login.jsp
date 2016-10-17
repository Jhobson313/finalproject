<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<img alt="Dream Big" src="C:/Users/User/Pictures/dream-big.jpg" height= 250px; width= 1300px><br>

	<title>Login</title>
</head>
<body>
<h1>
	Please Log In 
</h1>


<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width,
 initial-scale =1">
<title>DREAMSETTER</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<div class="container">
<div class="jumbotron">


	

<div class="container">
<nav class="navbar navbar-default">
	<div class="navbar-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" 
			data-toggle="collapse" data-target="#bs-example-navbar-
			collapse-1" aria-expanded="false">
			
			<span class="sr-only"></span>
			
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<h3>Login in with your Name and Email. Your Dreams are only a click away!!!</h3>
	  </div>
	
	<div class="collapse navbar-colllapse" id="#bs-example-navbar-
			collapse-1">
		<ul class="navbar-nav">
			<li class="active"><a href="#">DREAMSETTER<span class=
			"sr-only">(current)</span></a></li>
			<li><a href="#">About</a></li>
			<li class="dropdown">
			<a href="#" class="dropdown-toggle" 
			data-toggle="dropdown" role="button" aria-hashpopup
			="true" aria-expanded="false">Contact Us<span class="caret"></span></a>
			<ul class="dropdown-menu">
			<li><a href="#">Email </a>
			<li><a href="#">Phone </a>
			<li><a href="#">Set appointment </a></li>
			</ul>
		</ul>
	</div>
	
	
	</div>
</nav>

<div class="input-group input-group-lg">
			<span class="input-group-addon">Login</span> 
		</div>
		<br>
<ul class= "list-inline">
		<li class= "dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown">User Login</a>
		<span class="caret"></span>
		<ul class= "dropdown-menu">
		<li><a href="#">New User</a></li>
		<li><a href="#">Existing User</a></li>
		</ul>
		</li>
		</ul>
	
		<div class="input-group input-group-sm">
			<input type="text" class="form-control" placeholder="Full Name">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button">Enter</button>
			</span>
		</div>
		<br>
		<br>
		<div class="input-group input-group-sm">
			<input type="text" class="form-control" placeholder="Email">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button">Enter</button>
			</span>
		</div>
		<br>
		
		<div class="row">
			<div class="input-group">
				<div class="input-group-btn">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						User ID <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Facebook</span></a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Google+</a></li>
						<li><a href="#">Instagram</a></li>
					</ul>
					
				</div>
				<input type="text" class="form-control" aria-label="...">
			</div>
		</div>
		<br>
		<h3>Your Dreams are only a click away with DREAMSETTER!!!</h3>
	  
<br>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
 
</html>
<a href="<c:url value="/"/>">HOME</a>

</body>
</html>