<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textarea code="employer.descriptor.form.description" path="description"/>
		
		
	<acme:form-submit test="${command == 'create'}" 
	    code="employer.descriptor.form.button.create" action="/employer/descriptor/create"/>
	
	<acme:form-submit test="${command == 'show'}" 
		code="employer.descriptor.form.button.update" action="/employer/descriptor/update"/>
		
	<acme:form-submit test="${command == 'show'}" 
		code="employer.descriptor.form.button.delete" action="/employer/descriptor/delete"/>	
		    
	<acme:form-submit test="${command == 'show'}" 
	    code="employer.descriptor.form.button.create-duty" action="/employer/duty/create"/>    
	    	
	<acme:form-return code="employer.descriptor.form.return"/>
	
</acme:form>

<jstl:if test="${command == 'show'}">

<acme:redirect-button code="employer.descriptor.button.duty" action="/employer/duty/list?id=${id}"/>

</jstl:if>