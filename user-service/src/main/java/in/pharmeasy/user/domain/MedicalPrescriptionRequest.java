package in.pharmeasy.user.domain;

import java.sql.Date;

public class MedicalPrescriptionRequest {

	Long pharmacistId;
	Long medicalPrescriptionId;
	Long patientId;
	Date createDate;
	Date approvedDate;
	
	Boolean isApproved;
}

