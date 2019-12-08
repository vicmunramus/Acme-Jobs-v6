<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="employer.duty.list.title" path="titleDuty"/>
	<acme:list-column code="employer.duty.list.description" path="descriptionDuty"/>
</acme:list>

<acme:redirect-button code="employer.duty.list.button.create-duty" action="/employer/duty/create?descriptorId=${descriptorId}"/>
