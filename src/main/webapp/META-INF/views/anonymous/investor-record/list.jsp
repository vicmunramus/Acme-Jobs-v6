<%@ page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>

	<acme:list-column code="anonymous.investorRecord.list.label.name" path="name" width="50%"/>
	
	<acme:list-column code="anonymous.investorRecord.list.label.sector" path="sector" width="50%"/>
	
</acme:list>

<acme:redirect-button code="anonymous.investorRecord.listFiveStars.button.redirect" action="/anonymous/investor-record/list-fivestars"/>