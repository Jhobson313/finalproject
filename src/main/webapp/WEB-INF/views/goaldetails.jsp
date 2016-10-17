<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
 
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawAxisTickColors);

function drawAxisTickColors() {
      var data = new google.visualization.DataTable();
      data.addColumn('date', 'Time of Day');
      data.addColumn('number', 'Goal-Projected Progress');
      data.addColumn('number', 'Goal-Actual Progress');

      data.addRows([
        [new Date(2016, 1, 1), 0, 0],    [new Date(2016, 1, 7), 10, 5],   [new Date(2016, 2, 3), 20, 15], 
        [new Date(2016, 2, 10), 27, 19], [new Date(2016, 2, 17), 38, 30],  [new Date(2016, 2, 24), 49, 35],
        ]);

      var options = {
        hAxis: {
          title: 'Time',
          textStyle: {
            color: '#01579b',
            fontSize: 20,
            fontName: 'Arial',
            bold: true,
            italic: true
          },
          titleTextStyle: {
            color: '#01579b',
            fontSize: 16,
            fontName: 'Arial',
            bold: false,
            italic: true
          }
        },
        vAxis: {
          title: 'Goal',
          textStyle: {
            color: '#1a237e',
            fontSize: 24,
            bold: true
          },
          titleTextStyle: {
            color: '#1a237e',
            fontSize: 24,
            bold: true
          }
        },
        colors: ['#a52714', '#097138']
      };
      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
    </script>

</head>
<h1>
	<c:choose>
		<c:when test="${ empty depositAmount }">
			All Deposits
		</c:when>
		<c:otherwise>
			Deposits <c:out value="${ depositAmount }"/>
		</c:otherwise>
	</c:choose>
</h1>

<body>
<body>
    <div id="chart_div" style="width: 900px; height: 500px"></div>
  </body>

<h4>
	<a href="<c:url value="/goalsdashboard"/>">Back to the Dashboard</a>
</h4>

<a href="<c:url value="/"/>">HOME</a>

</body>
</html>