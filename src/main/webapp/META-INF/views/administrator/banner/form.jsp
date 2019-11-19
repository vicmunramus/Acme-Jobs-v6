<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.target" path="target"/>
	
	<jstl:choose>
		<jstl:when test="${creditCardNumber != null || param.commercial != null}">
			<acme:form-textbox code="administrator.banner.form.label.creditCardNumber" path="creditCardNumber"/>
			<acme:form-textbox code="administrator.banner.form.label.cvv" path="cvv"/>
			<acme:form-textbox placeholder="MM/YY" code="administrator.banner.form.label.expirationDate" path="expirationDate"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-url code="administrator.banner.form.label.jingle" path="jingle"/>
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'show'}" 
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
	<acme:form-submit test="${command == 'create' && param.commercial != null}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create?commercial"/>
	<acme:form-submit test="${command == 'create' && param.commercial == null}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create"/>
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
	
	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>