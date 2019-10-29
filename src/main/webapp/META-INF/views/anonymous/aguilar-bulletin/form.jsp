<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.aguilarBulletin.form.label.company" path="company"/>
	<acme:form-integer code="anonymous.aguilarBulletin.form.label.vacancy" path="vacancy"/>
	<acme:form-integer code="anonymous.aguilarBulletin.form.label.salary" path="salary"/>
	<acme:form-textarea code="anonymous.aguilarBulletin.form.label.requirement" path="requirement"/>
	<acme:form-submit code="anonymous.aguilarBulletin.form.button.create" action="/anonymous/aguilar-bulletin/create"/>
	<acme:form-return code="anonymous.aguilarBulletin.form.button.return"/>
</acme:form>