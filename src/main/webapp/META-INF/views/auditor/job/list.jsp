<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="auditor.request.list.label.status" path="reference"/>
	<acme:list-column code="auditor.request.list.label.title" path="title"/>
	<acme:list-column code="auditor.request.list.label.creationMoment" path="deadline"/>
</acme:list>
