<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [
					<jstl:forEach var="item" items="${gridLabels}">
						<jstl:out value="\"${item}\"" escapeXml="false"/>,
					</jstl:forEach>
				],
				datasets : [
					{
						label : "Investor Records",
						backgroundColor : "rgba(22, 38, 212, 0.3)",
						borderColor : "rgba(22, 38, 212, 1)",
						data : [
							<jstl:forEach var="item" items="${dataInvestor}">
								<jstl:out value="\"${item}\"" escapeXml="false"/>,
							</jstl:forEach>
						]
					},{
						label : "Company Records",
						backgroundColor : "rgba(19, 157, 16, 0.3)",
						borderColor : "rgba(19, 157, 16, 1)",
						data : [
							<jstl:forEach var="item" items="${dataCompany}">
								<jstl:out value="\"${item}\"" escapeXml="false"/>,
							</jstl:forEach>
						]
					}
				]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0,
							suggestedMax : 5
						}
					}
				]
			},
			legend : {
				display : true
			}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>