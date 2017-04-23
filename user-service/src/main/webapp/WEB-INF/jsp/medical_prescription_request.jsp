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
					<h4>Medical Prescriptions</h4>
				</caption>
				<tr>
					<th>Id</th>
					<th>Details</th>
					<th>Create Date</th>
				</tr>
				<c:forEach var="medicalPrescription" items="${medicalPrescriptions}">
					<tr>
						<td><c:out value="${medicalPrescription.medicalRecordId}" /></td>						
						<td>
							<c:if test="${medicalPrescription.isApproved == 'PENDING'}">
								<span>Approval Pending</span>
							</c:if>							
							<c:if test="${medicalPrescription.isApproved == null}">	
								<form method="post" action="/patient/${medicalPrescription.patientId}/medical_prescription/${medicalPrescription.medicalRecordId}/medical_prescription_request">
									<input type="submit" class="btn btn-default" value="Request Prescription">
								</form>
							</c:if>
							<c:if test="${medicalPrescription.isApproved == 'APPROVED'}">
								<c:out value="${medicalPrescription.details}" />
							</c:if>							
						</td>						
						<td><c:out value="${medicalPrescription.createDate}" /></td>					
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>

