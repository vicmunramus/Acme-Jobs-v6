<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<jstl:choose>
		<jstl:when test="${creditCardNumber != null || command == 'create-commercial' || command == 'update-commercial'}">
			<acme:message code="administrator.banner.title.commercial"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:message code="administrator.banner.title.nonCommercial"/>
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.target" path="target"/>
	
	<jstl:choose>
		<jstl:when test="${creditCardNumber != null || command == 'create-commercial' || command == 'update-commercial'}">
			<acme:form-panel code="administrator.banner.form.label.creditCard">
				<acme:form-textbox code="administrator.banner.form.label.creditCardNumber" path="creditCardNumber"/>
				<acme:form-textbox code="administrator.banner.form.label.cardHolder" path="cardHolder"/>
				<acme:form-textbox code="administrator.banner.form.label.cvv" path="cvv"/>
				<acme:form-textbox placeholder="MM/YY" code="administrator.banner.form.label.expirationDate" path="expirationDate"/>
			</acme:form-panel>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-url code="administrator.banner.form.label.jingle" path="jingle"/>
		</jstl:otherwise>
	</jstl:choose>
	
	<jstl:if test="${requestScope['sponsor.userAccount.identity.name'] != null}">
		<acme:form-panel code="administrator.banner.form.label.sponsor">
			<acme:form-textbox readonly="true" code="administrator.banner.form.label.sponsor.name" path="sponsor.userAccount.identity.name"/>
			<acme:form-textbox readonly="true" code="administrator.banner.form.label.sponsor.surname" path="sponsor.userAccount.identity.surname"/>
		</acme:form-panel>
	</jstl:if>
	
	<acme:form-submit test="${command == 'show' && creditCardNumber != null}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update-commercial"/>
	<acme:form-submit test="${command == 'show' && creditCardNumber == null}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update-non-commercial"/>	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
		
	<acme:form-submit test="${command == 'create-commercial'}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create-commercial"/>
	<acme:form-submit test="${command == 'create-non-commercial'}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create-non-commercial"/>
		
	<acme:form-submit test="${command == 'update-commercial'}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update-commercial"/>
	<acme:form-submit test="${command == 'update-non-commercial'}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update-non-commercial"/>
		
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
		
	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>