<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>

	<h2>Customisation Parameters</h2><br>
	<h3>Spam</h3><br>

	<acme:form-textarea  code="administrator.customisationParameters.form.label.spamList"    path="spamList"/>
	<acme:form-double    code="administrator.customisationParameters.form.label.spamThreshold"  path="spamThreshold" placeholder="0 - 1"/>
	
	<acme:form-submit code="administrator.customisationParameters.form.button.update" action="/administrator/customisation-parameters/update"/>
	<acme:form-return code="administrator.customisationParameters.form.button.return" />
	
</acme:form>