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
<title>Test</title>
</head>

<body>
	<div id="container" class="container-fluid">
		
		<%@ include file="header.jsp"%>			
		<div>
			<table border="1" class="table table-striped table-responsive">
				<caption>
					<h4>Patients</h4>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Action</th>
				</tr>
				<c:forEach var="user" items="${patients}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="" /><a href="/patient/${user.id}/prescriptions" class="btn btn-default">View</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>

