<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.target" path="target"/>
	
	<jstl:choose>
		<jstl:when test="${creditCard != null || param.commercial=='y'}">
			<acme:form-textbox code="administrator.banner.form.label.creditCard" path="creditCard"/>
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
	<acme:form-submit test="${command == 'create' && param.commercial=='y'}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create?commercial=y"/>
	<acme:form-submit test="${command == 'create' && param.commercial=='n'}" 
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create?commercial=n"/>
	<acme:form-submit test="${command == 'update'}" 
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'delete'}" 
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
	
	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>