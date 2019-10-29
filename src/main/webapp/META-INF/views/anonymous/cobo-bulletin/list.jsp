  <%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list readonly="true">
	<acme:list-column code="anonymous.coboBulletin.list.label.creationDate"	    path="creationDate" width="20%"/>
	<acme:list-column code="anonymous.coboBulletin.list.label.author"		    path="author" width="10%"/>
	<acme:list-column code="anonymous.coboBulletin.list.label.salary" 		    path="salary" width="5%"/>
	<acme:list-column code="anonymous.coboBulletin.list.label.location" 		path="location" width="10%"/>
	<acme:list-column code="anonymous.coboBulletin.list.label.description" 		path="description" width="45%"/>
</acme:list>

<acme:redirect-button code="anonymous.coboBulletin.list.button.create" action="/anonymous/cobo-bulletin/create" width="200px"/>