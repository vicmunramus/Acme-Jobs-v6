<%@page language = "java"%>

<%@taglib prefix = "jstl" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "acme" tagdir = "/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="employer.application.form.reference" path="reference"/>
	<acme:form-moment code="employer.application.form.moment" path="moment"/>
	<acme:form-textbox code="employer.application.form.status" path="status"/>
	<acme:form-textarea code="employer.application.form.statement" path="statement"/>
	<acme:form-textarea code="employer.application.form.skills" path="skills"/>
	<acme:form-textarea code="employer.application.form.qualifications" path="qualifications"/>
	<acme:form-panel code="employer.application.form.job">
		<acme:form-textbox code="employer.application.form.job.reference" path="job.reference"/>
		<acme:form-textbox code="employer.application.form.job.title" path="job.title"/>
	</acme:form-panel>
	<jstl:if test="${status != 'PENDING'}">
	<acme:form-panel code="employer.application.form.resolution">
		<acme:form-textarea code="employer.application.form.resolutionJustification" path="resolutionJustification"/>
	</acme:form-panel>
	<acme:form-return code="employer.application.form.return"/>	
	</jstl:if>
</acme:form>
<jstl:if test="${status == 'PENDING'}">
	<acme:form>
		<acme:form-hidden path="reference"/>
		<acme:form-hidden path="moment"/>
		<acme:form-hidden path="status"/>
		<acme:form-hidden path="statement"/>
		<acme:form-hidden path="skills"/>
		<acme:form-hidden path="qualifications"/>
		<acme:form-hidden path="job.reference"/>
		<acme:form-hidden path="job.title"/>
		<acme:form-panel code="employer.application.form.resolution">
			<acme:form-textarea code="employer.application.form.resolutionJustification" path="resolutionJustification"/>
		</acme:form-panel>
		<acme:form-submit test="${command == 'show'}" 
			code="employer.applicaton.form.button.accept" 
			action="/employer/application/accept-application"/>
		<acme:form-submit test="${command == 'show'}" 
			code="employer.applicaton.form.button.reject" 
			action="/employer/application/reject-application"/>
		<acme:form-submit test="${command == 'reject-application'}" 
			code="employer.applicaton.form.button.reject" 
			action="/employer/application/reject-application"/>
		<acme:form-return code="employer.application.form.return"/>	
	</acme:form>
</jstl:if>