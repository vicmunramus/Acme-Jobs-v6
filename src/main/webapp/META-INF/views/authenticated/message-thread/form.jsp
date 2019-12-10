<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.messageThread.form.label.title" path="title" />
	
	<jstl:if test="${command == 'show'}">
	<acme:form-moment code="authenticated.messageThread.form.label.moment" path="moment" />
	<acme:form-textbox code="authenticated.messageThread.form.label.creator" path="creator.username" />
	<acme:form-submit code="authenticated.messageThread.form.button.messages" action="/authenticated/message/list?messageThreadId=${id}" method="get" />	
 	<acme:form-submit code="authenticated.messageThread.form.button.involvedUsers" action="/authenticated/user-account/list?messageThreadId=${id}" method="get" />	
	</jstl:if>
 	
 	<jstl:forEach var="item" items="${involvedUsers}">
	<jstl:out value="${item}" escapeXml="false"/>,
	</jstl:forEach>

 	<acme:form-submit test="${command == 'create'}" 
	    code="worker.application.form.button.create" action="/authenticated/message-thread/create"/>
	  
	<acme:form-return code="authenticated.messageThread.form.button.return"/>
	
</acme:form>
