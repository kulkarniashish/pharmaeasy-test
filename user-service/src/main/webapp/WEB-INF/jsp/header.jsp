<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
<!-- 		<div class="navbar-header"> -->
<%-- 			<img src="${contextPath}/resources/images/logo.jpg" /> --%>
<!-- 		</div> -->

		<ul class="nav navbar-nav navbar-right">
			<li>
				<h4>
		 			Welcome : ${pageContext.request.userPrincipal.name} | <a href="/logout"/"> Logout</a>
		 		</h4>
			</li>
		</ul>

		<%-- 		<p class="navbar-text navbar-right">Welcome <a href="#" class="navbar-link"><%= SecurityContextHolder.getContext().getAuthentication().getName() %></a>, <a href="${contextPath}/logout.do">Logout</a></p> --%>
		<ul class="dropdown-menu" role="menu">
			<li><a href="" data-ng-click="logout()" id="navbar-logout">Logout</a></li>
		</ul>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<security:authorize access="hasRole('ROLE_PATIENT')">
					<li><a href="/mr_pending_approvals">Pending Approvals</a></li>
					<li><a href="/record">Personal Records</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_DOCTOR')">
					<li><a href="">Patients</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_PHARMACIST')">
					<li><a href="">Pharmacy</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>