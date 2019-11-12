<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox  code="authenticated.offer.form.label.title"          path="title"/>
	<acme:form-textarea code="authenticated.offer.form.label.description"    path="description"/>
	<jstl:if test="${command != create}">
		<acme:form-moment   code="authenticated.offer.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-moment   code="authenticated.offer.form.label.deadline"       path="deadline"/>
	<acme:form-integer  code="authenticated.offer.form.label.minReward"   path="minReward"/>
	<acme:form-integer  code="authenticated.offer.form.label.maxReward"   path="maxReward"/>
	<acme:form-textbox  code="authenticated.offer.form.label.ticker"         path="ticker"/>
	
	<acme:form-submit test="${command = 'create' }" 
	 code="authenticated.consumer.offer.form.button.create" 
	 action="authenticated/consumer/offer/create"/>
	
	<acme:form-return code="authenticated.offer.form.button.return" />
</acme:form>