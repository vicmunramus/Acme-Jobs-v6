<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="employer.descriptor.form.description" path="description"/>
		
	<acme:form-return code="employer.descriptor.form.return"/>
	
</acme:form>
<acme:redirect-button code="employer.descriptor.button.duty" action="/employer/duty/list?id=${id}"/>