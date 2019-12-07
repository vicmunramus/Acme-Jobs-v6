<%@page language = "java"%>

<%@taglib prefix = "jstl" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "acme" tagdir = "/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="employer.job.form.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="employer.job.form.title" path="title"/>
	<acme:form-moment code="employer.job.form.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.salary" path="salary"/>
	<acme:form-url code="employer.job.form.moreInfo" path="moreInfo"/>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-textbox code="authenticated.job.form.status" path="status"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" 
	    code="employer.job.form.button.create" action="/employer/job/create"/>
	<acme:form-submit test="${command == 'show'}" 
		code="employer.job.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'update'}" 
		code="employer.job.form.button.update" action="/employer/job/update"/>	
	<acme:form-submit test="${command == 'show'}" 
		code="employer.job.form.button.delete" action="/employer/job/delete"/>
		
	<!--<acme:form-hidden path="jobId"/>-->	
	<acme:form-submit test="${command == 'show'}" 
		code="employer.job.form.button.create-descriptor" action="/employer/descriptor/create"/>		

	
	<acme:form-return code="employer.job.form.return"/>	
	
</acme:form>

<jstl:if test="${command == 'show'}">
<acme:redirect-button code="employer.job.redirect.descriptor" action="/employer/descriptor/show?id=${id}"/>
<acme:redirect-button code="employer.job.redirect.auditRecord" action="/employer/audit-records/list?id=${id}"/>
</jstl:if>