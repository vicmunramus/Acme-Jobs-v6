<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="authenticated.offer.list.label.title"	      path="title"        width="25%"/>
	<acme:list-column code="authenticated.offer.list.label.salaryRange"	  path="salaryRange"  width="25%"/>
	<acme:list-column code="authenticated.offer.list.label.deadline"	  path="deadline"     width="50%"/>
</acme:list>