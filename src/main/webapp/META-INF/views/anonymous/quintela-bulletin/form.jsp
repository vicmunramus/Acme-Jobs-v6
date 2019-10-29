<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.quintela-bulletin.form.label.title" path="title" />
	<acme:form-textbox code="anonymous.quintela-bulletin.form.label.author" path="author" />
	<acme:form-textbox code="anonymous.quintela-bulletin.form.label.priority" path="priority" />
	<acme:form-textbox code="anonymous.quintela-bulletin.form.label.deadlineDate" path="deadlineDate" />
	<acme:form-textarea code="anonymous.quintela-bulletin.form.label.text" path="text" />
	<acme:form-submit code="anonymous.quintela-bulletin.form.button.create" action="/anonymous/quintela-bulletin/create"/>
	<acme:form-return code="anonymous.quintela-bulletin.form.button.return"/>
</acme:form>

