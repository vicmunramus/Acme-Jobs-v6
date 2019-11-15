<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox  code="consumer.offer.form.label.title"          path="title"/>
	<acme:form-textarea code="consumer.offer.form.label.description"    path="description"/>
	
	<jstl:if test="${command != 'create'}">
		<acme:form-moment   code="consumer.offer.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	
	<acme:form-moment   code="consumer.offer.form.label.deadline"       path="deadline"/>
	<acme:form-integer  code="consumer.offer.form.label.minReward"   path="minReward"  placeholder="10000.50 EUR"/>
	<acme:form-integer  code="consumer.offer.form.label.maxReward"   path="maxReward"  placeholder="30000 EUR"/>
	<acme:form-textbox  code="consumer.offer.form.label.ticker"         path="ticker" placeholder="OAAAA-00000"/>
	
	<jstl:if test="${command == 'create' }">
		<acme:form-checkbox code="consumer.offer.form.label.accept" path="accept"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create' }"
	 code="consumer.offer.form.button.create" 
	 action="/consumer/offer/create"/>
	
	<acme:form-return code="consumer.offer.form.button.return" />
	
</acme:form>