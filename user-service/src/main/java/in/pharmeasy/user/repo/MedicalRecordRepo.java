package in.pharmeasy.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pharmeasy.user.domain.MedicalRecord;
import in.pharmeasy.user.domain.MedicalRecordRequest;

public interface MedicalRecordRepo extends JpaRepository<MedicalRecord, Long>{

	List<MedicalRecordRequest> findByPatientId(Long id);

}
