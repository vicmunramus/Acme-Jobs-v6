<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.munoz-bulletin.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="anonymous.munoz-bulletin.list.label.groupName" path="groupName" width="35%"/>
	<acme:list-column code="anonymous.munoz-bulletin.list.label.managerName" path="managerName" width="35%"/>
	<acme:list-column code="anonymous.munoz-bulletin.list.label.size" path="size" width="10%"/>
</acme:list>
<acme:redirect-button code="anonymous.munoz-bulletin.list.button.create" action="/anonymous/munoz-bulletin/create" width="200px"/>