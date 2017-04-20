package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.pharmeasy.user.domain.MedicalPrescriptionRequest;
import in.pharmeasy.user.value.ApproveStatus;

public interface MedicalPrescriptionRequestRepo extends JpaRepository<MedicalPrescriptionRequest, Long>{

	List<MedicalPrescriptionRequest> findByPatientId(Long id);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update test.medical_prescription_request set is_approved = 'APPROVED', approved_date = CURDATE() where patient_id = :patientId and pharmacist_id = :pharmacistId and medical_prescription_id = :medicalPrescriptionId")
	void updateStatusToApprovedForPatient(@Param("patientId") Long userId, @Param("pharmacistId") Long pharmacistId, @Param("medicalPrescriptionId") Long medicalPrescriptionId);

	List<MedicalPrescriptionRequest> findByPatientIdAndIsApprovedIn(Long userId, List<ApproveStatus> asList);

}
