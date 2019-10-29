<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list readonly="true">
	<acme:list-column code="anonymous.reinaBulletin.list.label.createDate"	path="createDate" width="20%"/>
	<acme:list-column code="anonymous.reinaBulletin.list.label.author"		path="author" width="10%"/>
	<acme:list-column code="anonymous.reinaBulletin.list.label.age" 		path="age" width="5%"/>
	<acme:list-column code="anonymous.reinaBulletin.list.label.title" 		path="title" width="10%"/>
	<acme:list-column code="anonymous.reinaBulletin.list.label.text" 		path="text" width="45%"/>
</acme:list>

<acme:redirect-button code="anonymous.reinaBulletin.list.button.create" action="/anonymous/reina-bulletin/create" width="200px"/>
