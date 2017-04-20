<!DOCTYPE html>
<!-- taglibs -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


<title>Test</title>
</head>

<body>
	<div id="container" class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"></a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<security:authorize access="hasRole('ROLE_PATIENT')">
					<li><a href="/patient">Patient</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_DOCTOR')">
					<li><a href="/doctors">Doctors</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_PHARMACIST')">
					<li><a href="/pharmacy">Pharmacy</a></li>
				</security:authorize>
			</ul>
		</div>

		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h2>Patients</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Medical Records</th>
					<th>Action</th>
				</tr>
				<c:forEach var="user" items="${patients}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="" /></td>
						<td><c:out value="" /><button type="submit" class="btn btn-default">Submit</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<%-- 		<tabset> <tab heading="Personal info"> <form:form --%>
		<%-- 			method="post" action="save.htm" commandName="user"> --%>
		<!-- 			<table class="table table-bordered"> -->
		<!-- 				<tr> -->
		<%-- 					<c:if test="${pageContext.request.userPrincipal.name != null}"> --%>
		<!-- 						<h2> -->
		<%-- 							Welcome : ${pageContext.request.userPrincipal.name} | <a --%>
		<!-- 								href="/logout"/"> Logout</a> -->
		<!-- 						</h2> -->
		<%-- 					</c:if> --%>
		<!-- 				</tr> -->

		<!-- 			</table> -->
		<%-- 		</form:form> </tab> </tabset> --%>

		<%-- 		<%-- <span><%= session.getAttribute("continueURL") %></span> --%>

		<%-- 		<security:authorize --%>
		<%-- 			access="hasRole('ROLE_PATIENT')"> --%>
		<!-- 			<h3>Medical History</h3> -->
		<%-- 		</security:authorize> --%>

		<!-- 		<div class="row"> -->
		<%-- 			<security:authorize --%>
		<%-- 				access="hasRole('ROLE_PATIENT')"> --%>
		<!-- 				<div class="col-sm-3 col-md-2"> -->
		<!-- 					<a href="http://frontdesk.mediaiqdigital.com" class="thumbnail"> -->
		<!-- 						<img src="images/sales.png" alt="Frontdesk"> <span -->
		<!-- 						class="caption"> -->

		<!-- 					</span> -->
		<!-- 					</a> -->
		<!-- 				</div> -->
		<%-- 			</security:authorize> --%>
		<!-- 		</div> -->

		<!-- 		<div class="row"> -->
		<%-- 			<security:authorize --%>
		<%-- 				access="hasRole('ROLE_DOCTOR')"> --%>
		<!-- 				<div class="col-sm-3 col-md-2"> -->
		<!-- 					<span -->
		<!-- 						class="caption"> -->
		<!-- 							Add Medical Record -->
		<!-- 							Request Medical Record -->
		<!-- 							List Patients -->
		<!-- 					</span> -->
		<!-- 					</a> -->
		<!-- 				</div> -->
		<%-- 			</security:authorize> --%>
		<!-- 		</div> -->
	</div>
</body>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

</html>
