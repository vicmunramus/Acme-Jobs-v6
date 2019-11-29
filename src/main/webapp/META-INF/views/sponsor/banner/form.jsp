<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-url code="sponsor.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="sponsor.banner.form.label.target" path="target"/>
	
	<jstl:choose>
		<jstl:when test="${sponsor.creditCard != null}">
			<acme:form-panel code="sponsor.banner.form.label.creditCard">
				<acme:form-textbox code="sponsor.banner.form.label.creditCardNumber" path="sponsor.creditCard.creditCardNumber"/>
				<acme:form-textbox code="sponsor.banner.form.label.cardHolder" path="sponsor.creditCard.cardHolder"/>
				<acme:form-textbox code="sponsor.banner.form.label.cvv" path="sponsor.creditCard.cvv"/>
				<acme:form-textbox placeholder="MM/YY" code="sponsor.banner.form.label.expirationDate" path="sponsor.creditCard.expirationDate"/>
			</acme:form-panel>
		</jstl:when>
		<jstl:otherwise>
			<acme:form-url code="sponsor.banner.form.label.jingle" path="jingle"/>
		</jstl:otherwise>
	</jstl:choose>
	
	<acme:form-return code="sponsor.banner.form.button.return"/>
</acme:form>