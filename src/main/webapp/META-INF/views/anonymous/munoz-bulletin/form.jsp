<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.munoz-bulletin.label.groupName" path="groupName"/>
	<acme:form-textbox code="anonymous.munoz-bulletin.label.managerName" path="managerName"/>
	<acme:form-integer code="anonymous.munoz-bulletin.label.size" path="size"/>
	
	<acme:form-submit code="anonymous.munoz-bulletin.button.create" action="/anonymous/munoz-bulletin/create"/>
  	<acme:form-return code="anonymous.munoz-bulletin.button.return"/>
</acme:form>
