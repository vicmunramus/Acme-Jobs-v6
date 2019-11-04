<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.investorRecord.list.label.name" path="name" width="20%"/>
	<acme:list-column code="anonymous.investorRecord.list.label.sector" path="sector" width="20%"/>
</acme:list>
<acme:redirect-button code="anonymous.investorRecord.listFiveStars.button.redirect" action="/anonymous/investor-Record/list_fivestars" width="200px"/>