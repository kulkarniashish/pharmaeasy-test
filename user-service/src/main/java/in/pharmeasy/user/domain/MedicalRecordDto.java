package in.pharmeasy.user.domain;

import java.util.Date;

public class MedicalRecordDto {

	private Long medicalRecordId;
	private Long patientId;
	private Date createDate;
	private String details;
	private String isApproved;

	public MedicalRecordDto(Long medicalRecordId, Date createDate, String details, String isApproved) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.createDate = createDate;
		this.details = details;
		this.isApproved = isApproved;
	}
	
	public MedicalRecordDto() {		
	}

	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

}
