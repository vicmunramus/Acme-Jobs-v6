<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form >
	<acme:form-textbox code="provider.request.form.label.title" path="title" />
	<acme:form-textarea code="provider.request.form.label.description" path="description" />
	<jstl:if test="${command != 'create'}">
		<acme:form-moment   code="provider.request.form.label.createdAt" path="createdAt" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="provider.request.form.label.deadline" path="deadline" />
	<acme:form-textbox code="provider.request.form.label.reward" path="reward" placeholder="1.00 EUR"/>
	<acme:form-textbox code="provider.request.form.label.ticker" path="ticker" placeholder="RAAAA-00000"/>
	
	<jstl:if test="${command == 'create' }">
		<acme:form-checkbox code="provider.request.form.label.accept" path="accept"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create' }"
	 code="provider.request.form.button.create" 
	 action="/provider/request/create" />	
	<acme:form-return code="provider.request.form.button.return" />
</acme:form>

