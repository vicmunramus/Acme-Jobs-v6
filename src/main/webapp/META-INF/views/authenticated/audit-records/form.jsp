<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="authenticated.auditRecord.form.title" path="title"/>
	<acme:form-textbox code="authenticated.auditRecord.form.status" path="status"/>
	<acme:form-moment code="authenticated.auditRecord.form.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="authenticated.auditRecord.form.body" path="body"/>
		
	<acme:form-return code="authenticated.auditRecord.form.return"/>
	
</acme:form>




