<%@page language = "java"%>

<%@taglib prefix = "jstl" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "acme" tagdir = "/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.job.form.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.job.form.title" path="title"/>
	<acme:form-moment code="authenticated.job.form.deadline" path="deadline"/>
	<acme:form-money code="authenticated.job.form.salary" path="salary"/>
	<acme:form-url code="authenticated.job.form.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="authenticated.job.form.status" path="status"/>
	
	<acme:form-return code="authenticated.job.form.return"/>	
</acme:form>
<acme:redirect-button code="authenticated.job.redirect.descriptor" action="/authenticated/descriptor/show?id=${id}"/>
<acme:redirect-button code="authenticated.job.redirect.auditRecord" action="/authenticated/audit-records/list?id=${id}"/>
<acme:redirect-button code="authenticated.job.redirect.application" action="/worker/application/create?jobId=${id}"/>