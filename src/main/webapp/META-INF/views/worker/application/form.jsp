<%@page language = "java"%>

<%@taglib prefix = "jstl" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "acme" tagdir = "/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="worker.application.form.reference" path="reference"/>
	<acme:form-moment code="worker.application.form.moment" path="moment"/>
	<acme:form-textbox code="worker.application.form.status" path="status"/>
	<acme:form-textarea code="worker.application.form.statement" path="statement"/>
	<acme:form-textarea code="worker.application.form.skills" path="skills"/>
	<acme:form-textarea code="worker.application.form.qualifications" path="qualifications"/>
	<acme:form-panel code="worker.application.form.job">
		<acme:form-textbox code="worker.application.form.job.reference" path="job.reference"/>
		<acme:form-textbox code="worker.application.form.job.title" path="job.title"/>
	</acme:form-panel>
	<acme:form-panel code="worker.application.form.resolution">
		<acme:form-textarea code="worker.application.form.resolutionJustification" path="resolutionJustification"/>
	</acme:form-panel>
	<acme:form-return code="worker.application.form.return"/>	
</acme:form>