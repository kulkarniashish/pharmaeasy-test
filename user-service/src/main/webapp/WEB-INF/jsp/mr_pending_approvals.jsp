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
					<h3>Medical Record Request</h3>
				</caption>
				<tr>
					<th>Id</th>
					<th>Doctor Id</th>
					<th>MedicalRecordId</th>
					<th>Action</th>
				</tr>
				<c:forEach var="mr_pending_approval" items="${mr_pending_approvals}">
					<tr>
						<td><c:out value="${mr_pending_approval.id}" /></td>						
						<td>
							<c:out value="${mr_pending_approval.doctorId}" />
						</td>						
						<td><c:out value="${mr_pending_approval.medicalRecordId}" /></td>
						<td>
							<form method="post" action="/doctor/${mr_pending_approval.doctorId}/medical_record_id/${mr_pending_approval.medicalRecordId}/medical_record_request/approve">
									<input type="submit" class="btn btn-default" value="Approve">
								</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div>
			<table border="1" class="table table-striped table-responsive">
				<caption>
					<h3>Medical Prescription Request</h3>
				</caption>
				<tr>
					<th>Id</th>
					<th>Pharmacy Id</th>
					<th>Medical Presciption Id</th>
					<th>Action</th>
				</tr>
				<c:forEach var="pr_pending_approval" items="${pr_pending_approvals}">
					<tr>
						<td><c:out value="${pr_pending_approval.id}" /></td>						
						<td>
							<c:out value="${pr_pending_approval.pharmacistId}" />
						</td>						
						<td><c:out value="${pr_pending_approval.medicalPrescriptionId}" /></td>
						<td>
							<form method="post" action="/doctor/${pr_pending_approval.pharmacistId}/medical_prescription_id/${pr_pending_approval.medicalPrescriptionId}/medical_prescription_request/approve">
									<input type="submit" class="btn btn-default" value="Approve">
								</form>
						</td>						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

