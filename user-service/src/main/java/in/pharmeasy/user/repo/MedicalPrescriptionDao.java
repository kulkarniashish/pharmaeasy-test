package in.pharmeasy.user.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import in.pharmeasy.user.domain.MedicalPrescriptionDto;
import in.pharmeasy.user.domain.MedicalPrescriptionDtoRowMapper;

@Component
public class MedicalPrescriptionDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<MedicalPrescriptionDto> findAllMedicalPrescriptiosForPatient(Long patientId, Long pharmacistId){
		
		String sql = "select mr.id, mr.create_date, mr.details, mrr.is_approved, mr.patient_id from test.medical_prescription mr" +
					" left join " +
					" test.medical_prescription_request mrr on mr.patient_id = mrr.patient_id and mr.id = mrr.medical_prescription_id" +
					" where mrr.pharmacist_id = :pharmacistId or mrr.pharmacist_id is null" +
					" and mr.patient_id = :patientId";
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("pharmacistId", pharmacistId);
		 parameters.put("patientId", patientId);

		List<MedicalPrescriptionDto> result = namedParameterJdbcTemplate.query(sql, parameters, new MedicalPrescriptionDtoRowMapper());
		return result;
	}

}
