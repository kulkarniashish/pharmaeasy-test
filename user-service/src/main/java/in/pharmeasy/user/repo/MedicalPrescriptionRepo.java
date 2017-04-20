package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pharmeasy.user.domain.MedicalPrescription;
import in.pharmeasy.user.domain.MedicalRecord;
import in.pharmeasy.user.domain.MedicalRecordRequest;

public interface MedicalPrescriptionRepo extends JpaRepository<MedicalPrescription, Long>{

	List<MedicalPrescription> findByPatientId(Long id);

}
