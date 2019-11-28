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

	<acme:form-return code="employer.application.form.return"/>	
</acme:form>