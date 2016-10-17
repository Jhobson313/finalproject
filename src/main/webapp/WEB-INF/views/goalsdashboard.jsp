<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Goals Dashboard</title>
</head>
 <script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {
		packages : [ "calendar" ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var dataTable = new google.visualization.DataTable();
		dataTable.addColumn({
			type : 'date',
			id : 'Date'
		});
		dataTable.addColumn({
			type : 'number',
			id : 'Progress'
		});
		dataTable.addRows([ [ new Date(2016, 1, 16), 10 ],
				[ new Date(2016, 2, 17), 50 ], [ new Date(2016, 3, 13), 37 ],
				[ new Date(2016, 4, 13), 60 ], [ new Date(2016, 5, 13), 50 ],
				[ new Date(2016, 6, 13), 32 ], [ new Date(2016, 7, 13), 32 ],
				[ new Date(2016, 8, 13), 39 ], [ new Date(2016, 9, 13), 37 ],
				[ new Date(2016, 10, 13), 50 ], [ new Date(2016, 11, 14), 50 ],
				[ new Date(2016, 12, 15), 30 ], ]);

		var chart = new google.visualization.Calendar(document
				.getElementById('calendar_basic'));

		var options = {
			title : "Goals Progress",
			height : 350,
		};

		chart.draw(dataTable, options);
	}
</script>

</head>

<body>
	<strong> Here's a list of your goals

		<ul>
			<li>Goal 1 <a href="<c:url value="/goaldetails"/>"> Details</a></li>
			<li>Goal 2 <a href="<c:url value="/goaldetails"/>"> Details</a></li>
			<li>Add Goal</li>
		</ul>
	</strong>

	<h4>
	<a href="<c:url value="/deposit-details"/>">Deposit Details</a>
	<a href="<c:url value="/addgoal"/>"> Add A NEW GOAL</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>

</body>
</html>