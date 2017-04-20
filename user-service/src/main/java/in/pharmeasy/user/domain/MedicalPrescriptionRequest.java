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
@Table(name = "medical_prescription_request", catalog = "test")
public class MedicalPrescriptionRequest {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicalPrescriptionRequest(Long pharmacistId, Long medicalPrescriptionId, Long patientId) {
		this.pharmacistId = pharmacistId;
		this.medicalPrescriptionId = medicalPrescriptionId;
		this.patientId = patientId;
		this.createDate = new Date();
		this.isApproved = ApproveStatus.PENDING;
	}
	
	public MedicalPrescriptionRequest() {
		
	}

	public Long getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(Long pharmacistId) {
		this.pharmacistId = pharmacistId;
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

	public Long getMedicalPrescriptionId() {
		return medicalPrescriptionId;
	}

	public void setMedicaPrescriptionId(Long medicalPrescriptionId) {
		this.medicalPrescriptionId = medicalPrescriptionId;
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private Long pharmacistId;
	private Long medicalPrescriptionId;
	private Long patientId;
	private Date createDate;
	private Date approvedDate;
	
	@Enumerated(EnumType.STRING)
	private ApproveStatus isApproved = ApproveStatus.PENDING;
	
	
}

