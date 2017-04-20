package in.pharmeasy.user.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_record", catalog = "test")
public class MedicalRecord {

	public MedicalRecord(Long patientId) {
		super();
		this.patientId = patientId;
	}
	
	public MedicalRecord() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private Long patientId;
	private String details;
	
	private Date createDate;
}
