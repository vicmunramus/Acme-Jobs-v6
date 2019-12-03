<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="auditor.job.form.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="auditor.job.form.title" path="title"/>
	<acme:form-moment code="auditor.job.form.deadline" path="deadline"/>
	<acme:form-money code="auditor.job.form.salary" path="salary"/>
	<acme:form-url code="auditor.job.form.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="authenticated.job.form.status" path="status"/>

	<acme:form-return code="auditor.job.form.return"/>	
</acme:form>
<acme:redirect-button code="auditor.job.redirect.descriptor" action="/auditor/descriptor/show?id=${id}"/>
<acme:redirect-button code="auditor.job.redirect.auditRecord" action="/auditor/audit-records/list?id=${id}"/>