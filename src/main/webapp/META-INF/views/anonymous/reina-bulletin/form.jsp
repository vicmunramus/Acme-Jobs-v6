<%@page language ="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.reinaBulletin.form.label.author" path="author"/>
	<acme:form-textbox code="anonymous.reinaBulletin.form.label.age" path="age"/>
	<acme:form-textbox code="anonymous.reinaBulletin.form.label.title" path="title"/>
	<acme:form-textarea code="anonymous.reinaBulletin.form.label.text" path="text"/>
	
	<acme:form-submit code="anonymous.reinaBulletin.form.button.submit" action="/anonymous/reina-bulletin/create"/>
	<acme:form-return code="anonymous.reinaBulletin.form.button.return" />
</acme:form>