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
			<h3>Add New Medical Record</h3>
			<form:form method="post" action="record"
				commandName="prescription" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">Details</label>
					 <div class="col-sm-10">
						<form:input path="details" class="form-control" placeholder="Medical Details" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>
		</div>
		

		<div>
			<table border="1" class="table table-striped table-responsive">
				<caption>
					<h4>Medical History</h4>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalRecord" items="${medicalRecords}">
					<tr>
						<td><c:out value="${medicalRecord.id}" /></td>
						<td><c:out value="${medicalRecord.details}" /></td>
						<td><c:out value="${medicalRecord.createDate}" /></td>

					</tr>
				</c:forEach>
			</table>
		</div>
		<hr>

		<div>
			<h3>Add New Prescription</h3>
			<form:form method="post" action="prescription"
				commandName="prescription" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">Details</label>
					 <div class="col-sm-10">
						<form:input path="details" class="form-control" placeholder="Prescription Details" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>
		</div>

		<div>
			<table border="1" class="table table-striped table-responsive">
				<caption>
					<h4>Presciptions</h4>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalPresciption" items="${medicalPrescriptions}">
					<tr>
						<td><c:out value="${medicalPresciption.id}" /></td>
						<td><c:out value="${medicalPresciption.details}" /></td>
						<td><c:out value="${medicalPresciption.createDate}" /></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

