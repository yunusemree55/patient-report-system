package lab_report.lab.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.PatientService;
import lab_report.lab.business.abstracts.PersonMailSenderService;
import lab_report.lab.business.business_rules.patient_rules.PatientBusinessRulesService;
import lab_report.lab.business.requests.patient_requests.AddPatientRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientPasswordRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientUsernameRequest;
import lab_report.lab.business.responses.patient_responses.GetAllPatientResponse;
import lab_report.lab.business.responses.patient_responses.GetPatientResponse;
import lab_report.lab.core.adapters.spring_security_crypto.PasswordEncoderService;
import lab_report.lab.core.utilities.mappers.model_mapper.ModelMapperService;
import lab_report.lab.data_access.abstracts.PatientRepository;
import lab_report.lab.entities.concretes.Patient;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientManager implements PatientService{
		
	private PatientRepository patientRepository;
	private ModelMapperService modelMapperService;
	private PatientBusinessRulesService patientBusinessRulesService;
	private PasswordEncoderService passwordEncoderService;
	private PersonMailSenderService personMailSenderService;
	
	@Override
	public List<GetAllPatientResponse> getAll() {

		List<GetAllPatientResponse> patientResponseList = patientRepository.findAll().stream()
				.map(patient -> modelMapperService.forResponse().map(patient, GetAllPatientResponse.class)).collect(Collectors.toList());
		return patientResponseList;
	}

	@Override
	public GetPatientResponse getById(int id) {
		
		Patient target = patientRepository.findById(id).orElseThrow();
		
		GetPatientResponse patientResponse = modelMapperService.forResponse().map(target, GetPatientResponse.class);

		return patientResponse;
	}
	
	
	@Override
	public void add(AddPatientRequest addPatientRequest) {
		
		patientBusinessRulesService.checkEmailIfExistsBefore(addPatientRequest.getEmail());
		patientBusinessRulesService.checkUsernameIfExistsBefore(addPatientRequest.getUsername());
		patientBusinessRulesService.checkPatientNationalIdentityIfExistsBefore(addPatientRequest.getIdentityNumber());
		patientBusinessRulesService.checkPasswordFieldsIfMatches(addPatientRequest.getPassword(), addPatientRequest.getConfirmPassword());
		
		Patient patient = modelMapperService.forRequest().map(addPatientRequest, Patient.class);
		
		String encodedPassword = passwordEncoderService.encodePassword(patient.getPassword());
		
		patient.setPassword(encodedPassword);
		
		
		patientRepository.save(patient);
		
		personMailSenderService.accountCreatedMessage(patient.getEmail());
		
	}

	@Override
	public void updateUsername(UpdatePatientUsernameRequest updatePatientUsernameRequest) {
		
		patientBusinessRulesService.checkUsernameIfExistsBefore(updatePatientUsernameRequest.getUsername());
		
		patientRepository.updateUsername(updatePatientUsernameRequest.getId(), updatePatientUsernameRequest.getUsername());
		
		
	}

	@Override
	public void updatePassword(UpdatePatientPasswordRequest updatePatientPasswordRequest) {
		
		patientBusinessRulesService.checkPasswordFieldsIfMatches(updatePatientPasswordRequest.getPassword(), updatePatientPasswordRequest.getConfirmPassword());
		
		String encodedNewPassword = passwordEncoderService.encodePassword(updatePatientPasswordRequest.getPassword());
		
		patientRepository.updatePassword(updatePatientPasswordRequest.getId(), encodedNewPassword);
		
	}

	@Override
	public boolean checkPersonByEmail(String email) {
		
		boolean isExists = patientRepository.existsByEmail(email);
		
		return isExists;
		
	}

	@Override
	public boolean checkPersonByUsername(String username) {
		
		boolean isExists = patientRepository.existsByUsername(username);
		
		return isExists;
	}

	@Override
	public boolean checkPatientByIdentityNumber(String identityNumber) {
		
		boolean isExists = patientRepository.existsByIdentityNumber(identityNumber);
		
		return isExists;
		
	}
	

}
