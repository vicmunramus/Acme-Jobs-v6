<%@ page language="java" %>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list readonly="true">
	<acme:list-column code="anonymous.doblado-bulletin.list.label.moment" path ="moment" width="10%"/>
	<acme:list-column code="anonymous.doblado-bulletin.list.label.name" path ="name" width="15%"/>
	<acme:list-column code="anonymous.doblado-bulletin.list.label.location" path ="location" width="10%"/>
	<acme:list-column code="anonymous.doblado-bulletin.list.label.degree" path ="degree" width="15%"/>
	<acme:list-column code="anonymous.doblado-bulletin.list.label.text" path ="text" width="50%"/>
</acme:list>

<acme:redirect-button code="anonymous.doblado-bulletin.button.create" action="/anonymous/doblado-bulletin/create" width="200px"/>