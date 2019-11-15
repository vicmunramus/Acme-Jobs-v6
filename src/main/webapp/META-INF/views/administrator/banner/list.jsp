<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.banner.list.label.picture" path="picture" width="20%"/>
	<acme:list-column code="administrator.banner.list.label.slogan" path="slogan" width="40%"/>
</acme:list>

<acme:redirect-button code="administrator.banner.button.redirect.create.commercial" action="/administrator/banner/create?commercial=y"/>
<acme:redirect-button code="administrator.banner.button.redirect.create.non-commercial" action="/administrator/banner/create?commercial=n"/>