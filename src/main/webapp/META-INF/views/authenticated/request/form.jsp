<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.request.form.label.title" path="title" />
	<acme:form-moment code="authenticated.request.form.label.createdAt" path="createdAt" />
	<acme:form-moment code="authenticated.request.form.label.deadline" path="deadline" />
	<acme:form-textarea code="authenticated.request.form.label.description" path="description" />
	<acme:form-textbox code="authenticated.request.form.label.reward" path="reward" />
	<acme:form-textbox code="authenticated.request.form.label.ticket" path="ticket" />
	
	<acme:form-return code="authenticated.request.form.button.return"/>
</acme:form>

