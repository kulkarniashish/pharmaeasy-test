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
		<%@ include file="header.jsp"%>
		
		<div>
			<h1>Add New MR</h1>
			<form:form method="post" action="record">
				<table>
					<tr>
						<td>Details :</td>
						<td><form:input path="details" /></td>
					</tr>					
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>

		</div>
		
		<div>
			<table border="1" cellpadding="5">
				<caption>
					<h3>Medical History</h3>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalRecord" items="${medicalRecords}">
					<tr>
						<td><c:out value="${medicalRecord.id}" /></td>						
						<td>
							<c:out value="${medicalRecord.details}" />
						</td>						
						<td><c:out value="${medicalRecord.createDate}" /></td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div>
			<h3>Add New Prescription</h3>
			<form:form method="post" action="prescription" commandName="prescription">
				<table>
					<tr>
						<td>Details :</td>
						<td><form:input path="details" /></td>
					</tr>					
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		
		<div>
			<table border="1" cellpadding="5">
				<caption>
					<h3>Presciptions</h3>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalPresciption" items="${medicalPrescriptions}">
					<tr>
						<td><c:out value="${medicalPresciption.id}" /></td>						
						<td>
							<c:out value="${medicalPresciption.details}" />
						</td>						
						<td><c:out value="${medicalPresciption.createDate}" /></td>
						
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

