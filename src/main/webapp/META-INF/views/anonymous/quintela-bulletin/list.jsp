<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.quintela-bulletin.list.label.title" path="title" width="10%"/>
	<acme:list-column code="anonymous.quintela-bulletin.list.label.author" path="author" width="10%"/>
	<acme:list-column code="anonymous.quintela-bulletin.list.label.priority" path="priority" width="10%"/>
	<acme:list-column code="anonymous.quintela-bulletin.list.label.createdAt" path="createdAt" width="10%"/>
	<acme:list-column code="anonymous.quintela-bulletin.list.label.deadlineDate" path="deadlineDate" width="10%"/>
	<acme:list-column code="anonymous.quintela-bulletin.list.label.text" path="text" width="50%"/>
</acme:list>

<acme:redirect-button code="anonymous.quintela-bulletin.list.button.create" action="/anonymous/quintela-bulletin/create" width="200px"/>