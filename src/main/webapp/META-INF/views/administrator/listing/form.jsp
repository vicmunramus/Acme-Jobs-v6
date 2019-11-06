<%@ page language="java"%>

<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-integer code="administrator.listing.form.label.numberAnnouncement" path="numberAnnouncement"/>
	<acme:form-integer code="administrator.listing.form.label.numberCompanyRecords" path="numberCompanyRecords"/>
	<acme:form-integer code="administrator.listing.form.label.numberInvestorRecords" path="numberInvestorRecord"/>
	<acme:form-double code="administrator.listing.form.label.minimunRewardOffer" path="minimunRewardOffer"/>
	<acme:form-double code="administrator.listing.form.label.maximunRewardOffer" path="maximunRewardOffer"/>
	<acme:form-double code="administrator.listing.form.label.averageRewardOffer" path="averageRewardOffer"/>
	<acme:form-double code="administrator.listing.form.label.minimunRewardRequest" path="minimunRewardRequest"/>
	<acme:form-double code="administrator.listing.form.label.maximunRewardRequest" path="maximunRewardRequest"/>
	<acme:form-double code="administrator.listing.form.label.averageRewardRequest" path="averageRewardRequest"/>
	<acme:form-double code="administrator.listing.form.label.stdRequest" path="stdRequest"/>
	<acme:form-double code="administrator.listing.form.label.stdOffer" path="stdOffer"/>

</acme:form>