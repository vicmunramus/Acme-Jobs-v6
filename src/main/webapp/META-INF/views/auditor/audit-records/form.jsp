<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="employer.job.form.reference" path="job.reference"/>
	<acme:form-textbox code="employer.job.form.title" path="job.title"/>
	<acme:form-moment code="employer.job.form.deadline" path="job.deadline"/>
	<acme:form-money code="employer.job.form.salary" path="job.salary"/>
	<acme:form-url code="employer.job.form.moreInfo" path="job.moreInfo"/>
	<acme:form-textarea code="employer.job.form.description" path="job.description"/>

	<acme:form-return code="employer.job.form.return"/>	
</acme:form>
