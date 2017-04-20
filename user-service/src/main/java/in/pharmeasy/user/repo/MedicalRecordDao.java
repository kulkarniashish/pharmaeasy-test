package in.pharmeasy.user.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import in.pharmeasy.user.domain.MedicalRecordDto;
import in.pharmeasy.user.domain.MedicalRecordsDtoRowMapper;

@Component
public class MedicalRecordDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<MedicalRecordDto> findAllMedicalRecordsForPatient(Long patientId, Long doctorId){
		
		String sql = "select mr.id, mr.create_date, mr.details, mrr.is_approved, mr.patient_id from test.medical_record mr" +
					" left join " +
					" test.medical_record_request mrr on mr.patient_id = mrr.patient_id and mr.id = mrr.medical_record_id" +
					" where mrr.doctor_id = :doctorId or mrr.doctor_id is null" +
					" and mr.patient_id = :patientId";
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		 parameters.put("doctorId", doctorId);
		 parameters.put("patientId", patientId);

		List<MedicalRecordDto> result = namedParameterJdbcTemplate.query(sql, parameters, new MedicalRecordsDtoRowMapper());
		return result;
	}

}
