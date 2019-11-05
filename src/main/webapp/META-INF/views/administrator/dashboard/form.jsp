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
					"PRIMARY", "SECONDARY", "SERVICE"
				],
				datasets : [
					{
						label : "Investor Records",
						data : [
							<jstl:out value="${numberInvestorRecordPrimarySector}"/>,
							<jstl:out value="${numberInvestorRecordSecondarySector}"/>,
							<jstl:out value="${numberInvestorRecordServiceSector}"/>
						]
					},{
						label : "Company Records",
						data : [
							<jstl:out value="${numberCompanyRecordPrimarySector}"/>,
							<jstl:out value="${numberCompanyRecordSecondarySector}"/>,
							<jstl:out value="${numberCompanyRecordServiceSector}"/>
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