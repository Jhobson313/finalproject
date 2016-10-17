<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit A New Goal</title>
</head>
<body>
	<h1>Edit A New Goal Here</h1>
	<div class="input-group input-group-sm">
		<input type="text" class="form-control" placeholder="Goal Name">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button">Enter</button>
		</span>
	</div>
	<div class="input-group input-group-sm">
		<input type="text" class="form-control" placeholder="Goal Description">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button">Enter</button>
		</span>
	</div>
	<div class="input-group input-group-sm">
		<input type="text" class="form-control" placeholder="Goal Cost">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button">Enter</button>
		</span>
	</div>
	<div class="input-group input-group-sm">
		<input type="text" class="form-control" placeholder="Goal Due Date">
		<span class="input-group-btn">
			<button class="btn btn-default" type="button">Enter</button>
		</span>
	</div>



	<ul>
		<li>Name</li>
		<li>Description</li>
		<li>Due Date</li>
		<li>Cost</li>
	</ul>




</body>
 <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['MONTH (Year)',  'PROJECTED PROGRESS', 'ACTUAL PROGRESS'],
          ['November', 				10,         	15],
          ['December',				20,         	25],
          ['January',   			30,         	35],
          ['Febuary',   			40,         	45]
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