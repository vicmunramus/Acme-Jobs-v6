<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="employer.auditRecord.form.title" path="title"/>
	<acme:form-textbox code="employer.auditRecord.form.status" path="status"/>
	<acme:form-moment code="employer.auditRecord.form.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="employer.auditRecord.form.body" path="body"/>
		
	<acme:form-return code="employer.auditRecord.form.return"/>
	
</acme:form>




