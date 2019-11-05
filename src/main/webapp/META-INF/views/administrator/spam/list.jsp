<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="readonly">
	<acme:list-column code="administrator.spam.word.spanish" path="wordEs"/>
	<acme:list-column code="administrator.spam.word.english" path="wordEn"/>
	<acme:list-column code="administrator.spam.word.threshold" path="threshold"/>
</acme:list>