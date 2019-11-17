<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="consumer.offer.list.label.title"	       path="title"         width="20%"/>
	<acme:list-column code="consumer.offer.list.label.minReward"      path="minReward"     width="10%"/>
	<acme:list-column code="consumer.offer.list.label.maxReward"	   path="maxReward"     width="10%"/>
	<acme:list-column code="consumer.offer.list.label.deadline"	   path="deadline"      width="20%"/>
</acme:list>

<acme:redirect-button code="consumer.offer.list.button.create" action="/consumer/offer/create"/>