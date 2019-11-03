<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
	
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.challenge.list" action="/authenticated/challenge/list"/>
		</acme:menu-option>

	    <acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
	  
		  <acme:menu-suboption code="master.menu.anonymous.favourite-link-alvaro" action="http://www.youtube.com/user/CubyPuzzles"/>
		  <acme:menu-suboption code="master.menu.anonymous.favourite-link-jose" action="http://www.reddit.com/"/>
	      <acme:menu-suboption code="master.menu.anonymous.favourite-link-Carlos" action="http://www.github.com/"/>
		  <acme:menu-suboption code="master.menu.anonymous.favourite-link-enrique" action="https://9gag.com/"/>
		  <acme:menu-suboption code="master.menu.anonymous.favourite-link-Fran" action="http://www.twitch.com/"/>
		  <acme:menu-suboption code="master.menu.anonymous.favourite-link-victor" action="https://theemptypage.wordpress.com/2013/05/20/critical-perspectives-on-waluigi/"/>
      
          <acme:menu-separator/>
        
          <acme:menu-suboption code="master.menu.anonymous.bulletin-alvaro" action="/anonymous/aguilar-bulletin/list"/>
          <acme:menu-suboption code="master.menu.anonymous.bulletin.CoboBulletin" action="/anonymous/cobo-bulletin/list"/>
          <acme:menu-suboption code="master.menu.anonymous.doblado-bulletin" action="/anonymous/doblado-bulletin/list"/>
          <acme:menu-suboption code="master.menu.anonymous.bulletin.reinaBulletin" action="/anonymous/reina-bulletin/list"/>
          <acme:menu-suboption code="master.menu.anonymous.quintela-bulletin" action="/anonymous/quintela-bulletin/list"/> 
          <acme:menu-suboption code="master.menu.anonymous.munoz-bulletin" action="/anonymous/munoz-bulletin/list"/>
          
           <acme:menu-separator/>
           
          <acme:menu-suboption code="master.menu.anonymous.announcement" action="/anonymous/announcement/list"/>
        	
		  <acme:menu-separator/>
		  
		  <acme:menu-suboption code="master.menu.anonymous.company-records.list" action="/anonymous/company-records/list"/>
        	
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="hasRole('Authenticated')">
			<acme:menu-suboption code="master.menu.authenticated.request.list" action="/authenticated/request/list"/>
			<acme:menu-suboption code="master.menu.authenticated.company-records.list" action="/authenticated/company-records/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.announcement" action="/authenticated/announcement/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>