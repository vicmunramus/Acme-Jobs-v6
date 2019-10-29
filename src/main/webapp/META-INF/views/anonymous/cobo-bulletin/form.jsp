<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.coboBulletin.form.label.author" path="author"/>
	<acme:form-integer code="anonymous.coboBulletin.form.label.salary" path="salary"/>
	<acme:form-textbox code="anonymous.coboBulletin.form.label.location" path="location"/>
	<acme:form-textarea code="anonymous.coboBulletin.form.label.description" path="description"/>
	
	<acme:form-submit code="anonymous.coboBulletin.form.button.submit" action="/anonymous/cobo-bulletin/create"/>
	<acme:form-return code="anonymous.coboBulletin.form.button.return" />
</acme:form>