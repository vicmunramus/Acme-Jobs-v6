<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.aguilarBulletin.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="anonymous.aguilarBulletin.list.label.company" path="company" width="20%"/>
	<acme:list-column code="anonymous.aguilarBulletin.list.label.vacancy" path="vacancy" width="10%"/>
	<acme:list-column code="anonymous.aguilarBulletin.list.label.requirement" path="requirement" width="40%"/>
	<acme:list-column code="anonymous.aguilarBulletin.list.label.salary" path="salary" width="10%"/>
</acme:list>
<acme:redirect-button code="anonymous.aguilarBulletin.list.button.create" action="/anonymous/aguilar-bulletin/create" width="200px"/>