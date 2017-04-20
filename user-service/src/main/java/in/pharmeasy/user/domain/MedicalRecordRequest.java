package in.pharmeasy.user.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import in.pharmeasy.user.value.ApproveStatus;

@Entity
@Table(name = "medical_record_request", catalog = "test")
public class MedicalRecordRequest {

	public MedicalRecordRequest(Long doctorId, Long medicalRecordId, Long patientId) {
		super();
		this.doctorId = doctorId;
		this.medicalRecordId = medicalRecordId;
		this.patientId = patientId;
		this.createDate = new Date();
		this.isApproved = ApproveStatus.PENDING;
	}
	
	public MedicalRecordRequest(){
		
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private Long doctorId;
	
	private Long medicalRecordId;
	private Long patientId;
	private Date createDate;
	private Date approvedDate;
	
	@Enumerated(EnumType.STRING)
	private ApproveStatus isApproved = ApproveStatus.PENDING;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public ApproveStatus getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(ApproveStatus isApproved) {
		this.isApproved = isApproved;
	}
}

