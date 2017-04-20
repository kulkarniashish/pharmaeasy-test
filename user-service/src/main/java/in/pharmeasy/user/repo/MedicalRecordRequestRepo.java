package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.pharmeasy.user.domain.MedicalRecordRequest;
import in.pharmeasy.user.value.ApproveStatus;

public interface MedicalRecordRequestRepo extends JpaRepository<MedicalRecordRequest, Long>{

	List<MedicalRecordRequest> findByPatientId(Long patientId);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update test.medical_record_request set is_approved = 'APPROVED', approved_date = CURDATE() where patient_id = :patientId and doctor_id = :doctorId and medical_record_id = :medicalRecordId")
	void updateStatusToApprovedForPatient(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId, @Param("medicalRecordId") Long medicalRecordId);

	List<MedicalRecordRequest> findByPatientIdAndIsApprovedIn(Long userId, List<ApproveStatus> approvedStatus);

}
