<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="employer.job.form.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.title" path="title"/>
	<acme:form-moment code="employer.job.form.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.salary" path="salary"/>
	<acme:form-url code="employer.job.form.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.job.form.description" path="description"/>
	
	<a href="auditor/audit-records/list?id=${id}">Link AuditorRecords <br> </a>
	<br>
	
	<acme:form-return code="employer.job.form.return"/>
	
</acme:form>




