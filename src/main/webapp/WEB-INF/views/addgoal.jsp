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
<head>
<title>Add A New Goal</title>
</head>

<%@ include file="login_bar.jsp"%>

<form method="post" action="<c:url value="/addgoal"/>">
	
	<div class="input-group input-group-sm" action="<c:url value="/addgoal"/>">
		<label>Goal Description:</label> <input type="text"
			class="form-control" placeholder="Goal Description"
			value="${goals.description}" > <span class="input-group-btn">
			<button class="btn btn-default" type="submit" >Enter</button>
		</span>
	</div>

	<div class="input-group input-group-sm">
		<label>Start Date:</label><input type="text" class="form-control"
			placeholder="Goal Start Date" value="${goals.startDate}"> <span
			class="input-group-btn">
			<button class="btn btn-default" type="submit">Enter</button>
		</span>
	</div>

	<div class="input-group input-group-sm">
		<label>Due Date:</label><input type="text" class="form-control"
			placeholder="Goal Due Date" value="${goals.dueDate}"> <span
			class="input-group-btn">
			<button class="btn btn-default" type="submit">Enter</button>
		</span>
	</div>

	<div class="input-group input-group-sm">
		<label>Goal Amount:</label> <input type="text" class="form-control"
			placeholder="Goal Amount" value="${goals.amount}"> <span
			class="input-group-btn">
			<button class="btn btn-default" type="submit">Enter</button>
		</span>
	</div>
</form>


</body>



<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['MONTH (Year)',  'PROJECTED PROGRESS', 'ACTUAL PROGRESS'],
          ['November', 				1000,         	1500],
          ['December',				2000,         	2500],
          ['January',   			3000,         	3500],
          ['Febuary',   			4000,         	4500]
        ]);

        var options = {
          title: 'DREAMSETTER-GOALS STEP CHART',
          vAxis: {title: 'GOAL PROGRESS'},
          isStacked: true
        };

        var chart = new google.visualization.SteppedAreaChart(document.getElementById('chart_div'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>

<h4>
	<a href="<c:url value="/goalsdashboard"/>">This Submit button takes
		you back to the Dashboard</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>

</html>