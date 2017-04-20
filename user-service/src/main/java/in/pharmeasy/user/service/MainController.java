package in.pharmeasy.user.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

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

import in.pharmeasy.user.domain.MedicalPrescription;
import in.pharmeasy.user.domain.MedicalPrescriptionRequest;
import in.pharmeasy.user.domain.MedicalRecord;
import in.pharmeasy.user.domain.MedicalRecordRequest;
import in.pharmeasy.user.domain.User;
import in.pharmeasy.user.repo.MedicalPrescriptionDao;
import in.pharmeasy.user.repo.MedicalPrescriptionRepo;
import in.pharmeasy.user.repo.MedicalPrescriptionRequestRepo;
import in.pharmeasy.user.repo.MedicalRecordDao;
import in.pharmeasy.user.repo.MedicalRecordRepo;
import in.pharmeasy.user.repo.MedicalRecordRequestRepo;
import in.pharmeasy.user.repo.UserRepo;
import in.pharmeasy.user.value.ApproveStatus;
import in.pharmeasy.user.value.UserType;

@Controller
public class MainController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private MedicalRecordRepo medicalRecordRepo;

	@Autowired
	private MedicalPrescriptionRepo medicalPrescriptionRepo;
	
	@Autowired
	private MedicalPrescriptionRequestRepo medicalPrescriptionRequestRepo;
	
	@Autowired
	private MedicalRecordDao medicalRecordDao;
	
	@Autowired
	private MedicalPrescriptionDao medicalPrescriptionDao;
	
	@Autowired
	private MedicalRecordRequestRepo medicalRecordRequestRepo;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String visitHome() {

		UsernamePasswordAuthenticationToken oauth2User = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = oauth2User.getAuthorities();

		for(GrantedAuthority ga: authorities){
			if(ga.getAuthority().equals("ROLE_PATIENT"))
				return "redirect:/mr_pending_approvals";
			
			if(ga.getAuthority().equals("ROLE_DOCTOR"))
				return "redirect:/patient";
			
			if(ga.getAuthority().equals("ROLE_PHARMACIST"))
				return "redirect:/pharmacist";
		}

		return "redirect:/patient";
	}

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String savePatient(@ModelAttribute("patient") User patient) {
		ModelAndView mv = new ModelAndView("patient");
		patient.setUserType(UserType.PATIENT);
		userRepo.save(patient);
		return "redirect:/patient";
	}
	
	@RequestMapping(value = "/mr_pending_approvals", method = RequestMethod.GET)
	public ModelAndView getAllPendingApprovals() {
		ModelAndView mv = new ModelAndView("mr_pending_approvals");
		
		Long userId = getLoggedInUserId();
		mv.addObject("mr_pending_approvals", medicalRecordRequestRepo.findByPatientIdAndIsApprovedIn(userId, Arrays.asList( new ApproveStatus[] {ApproveStatus.PENDING, ApproveStatus.NOT_APPROVED})));
		mv.addObject("pr_pending_approvals", medicalPrescriptionRequestRepo.findByPatientIdAndIsApprovedIn(userId, Arrays.asList( new ApproveStatus[] {ApproveStatus.PENDING, ApproveStatus.NOT_APPROVED})));
		return mv;
	}

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public ModelAndView getAllPatients() {
		ModelAndView mv = new ModelAndView("patients");
		mv.addObject("patients", userRepo.findByUserType(UserType.PATIENT));
		mv.addObject("command", new User(UserType.PATIENT));
		return mv;
	}
	
	@RequestMapping(value = "/pharmacist", method = RequestMethod.GET)
	public ModelAndView getAllPharmacists() {
		ModelAndView mv = new ModelAndView("pharmacists");
		mv.addObject("patients", userRepo.findByUserType(UserType.PATIENT));
		return mv;
	}
		
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String saveMedicalRecord(@ModelAttribute("medicalRecord") MedicalRecord medicalRecord) {		
		medicalRecord.setCreateDate(new Date());
		medicalRecord.setPatientId(getLoggedInUserId());
		medicalRecordRepo.save(medicalRecord);
		return "redirect:/record";
	}
	
	@RequestMapping(value = "/prescription", method = RequestMethod.POST)
	public String saveMedicalPrescription(@ModelAttribute("medicalPrescription") MedicalPrescription medicalPrescription) {		
		medicalPrescription.setCreateDate(new Date());
		medicalPrescription.setPatientId(getLoggedInUserId());
		medicalPrescriptionRepo.save(medicalPrescription);
		return "redirect:/record";
	}

	@RequestMapping(value = "/patient/{patientId}/records", method = RequestMethod.GET)
	public ModelAndView getMedicalRecordsForPatient(@PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_records_request");
		Long userId = getLoggedInUserId();
		
		mv.addObject("medicalRecords", medicalRecordDao.findAllMedicalRecordsForPatient(patientId, userId));
		mv.addObject("command", new MedicalRecord(patientId));
		return mv;
	}
	
	@RequestMapping(value = "/patient/{patientId}/prescriptions", method = RequestMethod.GET)
	public ModelAndView getMedicalPrescriptionsForPatient(@PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_prescription_request");
		Long userId = getLoggedInUserId();
		
		mv.addObject("medicalPrescriptions", medicalPrescriptionDao.findAllMedicalPrescriptiosForPatient(patientId, userId));
		mv.addObject("command", new MedicalPrescription(patientId));
		return mv;
	}
	
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public ModelAndView getRecords() {
		ModelAndView mv = new ModelAndView("medical_records");
		
		Long userId = getLoggedInUserId();
		
		mv.addObject("medicalRecords", medicalRecordRepo.findByPatientId(userId));
		mv.addObject("medicalPrescriptions", medicalPrescriptionRepo.findByPatientId(userId));
		mv.addObject("command", new MedicalRecord(userId));
		mv.addObject("prescription", new MedicalPrescription(userId));
		return mv;
	}

	private Long getLoggedInUserId() {
		UsernamePasswordAuthenticationToken oauth2User = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();		
		User user = userRepo.findByUsername(oauth2User.getName());
		return user.getId();
	}

	@RequestMapping(value = "/patient/{patientId}/medical_record_request", method = RequestMethod.GET)
	public ModelAndView getMedicalRecordRequestsForPatient(@PathVariable Long patientId) {
		ModelAndView mv = new ModelAndView("medical_record_requests");
		mv.addObject("medicalRecordRequests", medicalRecordRequestRepo.findByPatientId(patientId));
		return mv;
	}

	@RequestMapping(value = "/patient/{patientId}/medical_record/{medicalRecordId}/medical_record_request", method = RequestMethod.POST)
	public ModelAndView createNewMedicalRecordRequest(@PathVariable Long medicalRecordId,
			@PathVariable Long patientId) {
		Long userId = getLoggedInUserId();
		
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		MedicalRecordRequest mrr = new MedicalRecordRequest(userId, medicalRecordId, patientId);
		medicalRecordRequestRepo.save(mrr);
		return mv;
	}

	@RequestMapping(value = "/doctor/{doctorId}/medical_record_id/{medicalRecordId}/medical_record_request/approve", method = RequestMethod.POST)
	public ModelAndView approve(@PathVariable Long doctorId, @PathVariable Long medicalRecordId) {
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		
		Long userId = getLoggedInUserId();
		medicalRecordRequestRepo.updateStatusToApprovedForPatient(userId, doctorId, medicalRecordId);
		return mv;
	}
	
	@RequestMapping(value = "/patient/{patientId}/medical_prescription/{medicalPrescriptionId}/medical_prescription_request", method = RequestMethod.POST)
	public ModelAndView createNewMedicalPrescriptionRequest(@PathVariable Long medicalPrescriptionId,
			@PathVariable Long patientId) {
		Long userId = getLoggedInUserId();
		
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		MedicalPrescriptionRequest mrr = new MedicalPrescriptionRequest(userId, medicalPrescriptionId, patientId);
		medicalPrescriptionRequestRepo.save(mrr);
		return mv;
	}

	@RequestMapping(value = "/doctor/{doctorId}/medical_prescription_id/{medicalPrescriptionId}/medical_prescription_request/approve", method = RequestMethod.POST)
	public ModelAndView approveMP(@PathVariable Long doctorId, @PathVariable Long medicalPrescriptionId) {
		ModelAndView mv = new ModelAndView("medical_record_request_approval");
		
		Long userId = getLoggedInUserId();
		medicalPrescriptionRequestRepo.updateStatusToApprovedForPatient(userId, doctorId, medicalPrescriptionId);
		return mv;
	}

}
