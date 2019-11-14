<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="provider.request.list.label.title" path="title" width="20%"/>
	<acme:list-column code="provider.request.list.label.deadline" path="deadline" width="40%"/>
	<acme:list-column code="provider.request.list.label.description" path="description" width="40%"/>	
</acme:list>
<acme:redirect-button code="provider.request.list.button.create" action="/provider/request/create"/>
