<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.doblado-bulletin.label.name" path="name"/>
	<acme:form-textbox code="anonymous.doblado-bulletin.label.location" path="location"/>
	<acme:form-textbox code="anonymous.doblado-bulletin.label.degree" path="degree"/>
	<acme:form-textarea code="anonymous.doblado-bulletin.label.text" path="text"/>
	
	<acme:form-submit code="anonymous.doblado-bulletin.button.create" action="/anonymous/doblado-bulletin/create"/>
  	<acme:form-return code="anonymous.doblado-bulletin.button.return"/>
</acme:form>