package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.pharmeasy.user.domain.MedicalRecordRequest;

public interface MedicalRecordRequestRepo extends JpaRepository<MedicalRecordRequest, Long>{

	List<MedicalRecordRequest> findByPatientId(Long patientId);

	@Query(nativeQuery = true, value = "update test.medical_record_request set is_approved = true, approved_date = CURDATE() where patient_id = :patientId and doctor_id = :doctorId")
	void updateStatusToApprovedForPatient(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);

}
