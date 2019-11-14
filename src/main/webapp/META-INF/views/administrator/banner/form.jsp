<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.target" path="target"/>
	<jstl:choose>
		<jstl:when test="${creditCard != null}">
			<acme:form-textbox code="administrator.banner.form.label.creditCard" path="creditCard"/>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-url code="administrator.banner.form.label.jingle" path="jingle"/>
		</jstl:otherwise>
	</jstl:choose>
	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>