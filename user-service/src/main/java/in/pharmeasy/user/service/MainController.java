package in.pharmeasy.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.pharmeasy.user.domain.MedicalRecordRequest;
import in.pharmeasy.user.domain.User;
import in.pharmeasy.user.repo.MedicalRecordRepo;
import in.pharmeasy.user.repo.MedicalRecordRequestRepo;
import in.pharmeasy.user.repo.UserRepo;
import in.pharmeasy.user.value.UserType;

@Controller
public class MainController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private MedicalRecordRepo medicalRecordRepo;

	@Autowired
	private MedicalRecordRequestRepo medicalRecordRequestRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView visitHome() {

		ModelAndView mv = new ModelAndView("index");

		UsernamePasswordAuthenticationToken oauth2User = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = oauth2User.getAuthorities();

		if (authorities.contains("DOCTOR")) {

		}

		return mv;
	}

	@RequestMapping("/patient/new")
	public ModelAndView showform() {
		return new ModelAndView("new_patient_form", "command", new User());
	}

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute("patient") User patient) {
		ModelAndView mv = new ModelAndView("patient");
		patient.setUserType(UserType.PATIENT);
		userRepo.save(patient);
		return mv;
	}

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public ModelAndView getAllPatients() {
		ModelAndView mv = new ModelAndView("patients");
		mv.addObject("patients", userRepo.findByUserType(UserType.PATIENT));
		return mv;
	}

	@RequestMapping(value = "/patient/{id}/records", method = RequestMethod.GET)
	public ModelAndView getMedicalRecordsForPatient(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("medical_records");
		mv.addObject("medicalRecords", medicalRecordRepo.findByPatientId(id));
		return mv;
	}

	@RequestMapping(value = "/patient/{patientId}/medical_record_request", method = RequestMethod.GET)
	public ModelAndView getMedicalRecordRequestsForPatient(@PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_record_requests");
		mv.addObject("medicalRecordRequests", medicalRecordRequestRepo.findByPatientId(patientId));
		return mv;
	}

	@RequestMapping(value = "/doctor/{doctorId}/patient/{patientId}/medical_record/{medical_record_id}/medical_record_request", method = RequestMethod.POST)
	public ModelAndView createNewMedicalRecordRequest(@PathVariable Long doctorId, @PathVariable Long medicalRecordId,
			@PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		MedicalRecordRequest mrr = new MedicalRecordRequest(doctorId, medicalRecordId, patientId);
		medicalRecordRequestRepo.save(mrr);
		return mv;
	}

	@RequestMapping(value = "/doctor/{doctorId}/patient/{patientId}/medical_record_request/approve", method = RequestMethod.POST)
	public ModelAndView approve(@PathVariable Long doctorId, @PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		medicalRecordRequestRepo.updateStatusToApprovedForPatient(patientId, doctorId);
		return mv;
	}
}
