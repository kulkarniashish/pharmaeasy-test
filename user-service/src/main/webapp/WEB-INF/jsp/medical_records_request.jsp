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
					<h4>Medical Records</h4>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalRecord" items="${medicalRecords}">
					<tr>
						<td><c:out value="${medicalRecord.medicalRecordId}" /></td>						
						<td>
							<c:if test="${medicalRecord.isApproved == 'PENDING'}">
								<span>Approval Pending</span>
							</c:if>							
							<c:if test="${medicalRecord.isApproved == null}">	
								<form method="post" action="/patient/${medicalRecord.patientId}/medical_record/${medicalRecord.medicalRecordId}/medical_record_request">
									<input type="submit" class="btn btn-default" value="Request MR">
								</form>
							</c:if>
							<c:if test="${medicalRecord.isApproved == 'APPROVED'}">
								<c:out value="${medicalRecord.details}" />
							</c:if>							
						</td>						
						<td><c:out value="${medicalRecord.createDate}" /></td>					
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

