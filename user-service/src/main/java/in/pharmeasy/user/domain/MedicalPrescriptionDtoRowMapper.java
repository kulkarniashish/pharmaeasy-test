package in.pharmeasy.user.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MedicalPrescriptionDtoRowMapper  implements RowMapper<MedicalPrescriptionDto> {

	  public MedicalPrescriptionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MedicalPrescriptionDto medicalRecordDto = new MedicalPrescriptionDto();
	    medicalRecordDto.setMedicalRecordId(rs.getLong("id"));
	    medicalRecordDto.setDetails(rs.getString("details"));
	    medicalRecordDto.setCreateDate(rs.getDate("create_date"));
	    medicalRecordDto.setIsApproved(rs.getString("is_approved"));
	    medicalRecordDto.setPatientId(rs.getLong("patient_id"));
	    return medicalRecordDto;
	  }

}
