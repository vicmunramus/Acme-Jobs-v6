<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>

	<h2>Spam</h2>

	<acme:form-textarea  code="administrator.customisationParameters.form.label.spamListEn"    path="spamListEn"/>
	<acme:form-textarea  code="administrator.customisationParameters.form.label.spamListEs"    path="spamListEs"/>
	<acme:form-double    code="administrator.customisationParameters.form.label.spamThreshold"  path="spamThreshold"/>
	
	<acme:form-submit code="administrator.customisationParameters.form.button.update" action="/administrator/customisation-parameters/update"/>
	<acme:form-return code="administrator.customisationParameters.form.button.return" />
	
</acme:form>