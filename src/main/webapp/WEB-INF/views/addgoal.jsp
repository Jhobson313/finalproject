<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Add A New Goal</title>
</head>
<body>
	<h1>Add A New Goal Here</h1>
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

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Goals');
        data.addColumn('number', 'Progress');
        data.addRows([
          ['Pay off Debt', 3],
          ['Holiday shopping', 1],
          ['Saving for the future', 1],
          ['Buy birthday gifts', 1],
          ['Purchase a New home', 2]
        ]);

        // Set chart options
        var options = {'title':'YOUR PERSONAL GOALS',
                       'width':800,
                       'height':600};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
    
  </body>

<h4>
	<a href="<c:url value="/goalsdashboard"/>">This Submit button takes
		you back to the Dashboard</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>
</html>