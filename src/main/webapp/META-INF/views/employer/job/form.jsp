<%@page language = "java"%>

<%@taglib prefix = "jstl" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "acme" tagdir = "/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="employer.job.form.title" path="title"/>
	<acme:form-moment code="employer.job.form.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.salary" path="salary"/>
	<acme:form-url code="employer.job.form.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="authenticated.job.form.status" path="status"/>

	<acme:form-return code="employer.job.form.return"/>	
</acme:form>
<acme:redirect-button code="employer.job.redirect.descriptor" action="/employer/descriptor/show?id=${id}"/>
<acme:redirect-button code="employer.job.redirect.auditRecord" action="/employer/audit-records/list?id=${id}"/>