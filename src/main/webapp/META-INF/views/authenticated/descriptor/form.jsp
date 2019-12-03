<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="authenticated.descriptor.form.description" path="description"/>
		
	<acme:form-return code="authenticated.descriptor.form.return"/>
	
</acme:form>
<acme:redirect-button code="authenticated.descriptor.button.duty" action="/authenticated/duty/list?id=${id}"/>