<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="employer.duty.form.title" path="titleDuty"/>
	<acme:form-textbox code="employer.duty.form.description" path="descriptionDuty"/>
	<acme:form-integer code="employer.duty.form.percentage" path="percentage"/>
		
	<acme:form-return code="employer.duty.form.return"/>
	
</acme:form>




