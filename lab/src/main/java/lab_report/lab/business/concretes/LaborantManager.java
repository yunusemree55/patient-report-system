package lab_report.lab.business.concretes;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.LaborantService;
import lab_report.lab.business.abstracts.PersonMailSenderService;
import lab_report.lab.business.business_rules.laborant_rules.LaborantBusinessRulesService;
import lab_report.lab.business.requests.laborabt_requests.AddLaborantRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantPasswordRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantUsernameRequest;
import lab_report.lab.business.responses.laborant_responses.GetAllLaborantResponse;
import lab_report.lab.business.responses.laborant_responses.GetLaborantResponse;
import lab_report.lab.core.adapters.spring_security_crypto.PasswordEncoderService;
import lab_report.lab.core.utilities.mappers.model_mapper.ModelMapperService;
import lab_report.lab.data_access.abstracts.LaborantRepository;
import lab_report.lab.entities.concretes.Laborant;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LaborantManager implements LaborantService {
	
	private LaborantRepository laborantRepository;
	private ModelMapperService modelMapperService;
	private LaborantBusinessRulesService laborantBusinessRulesService;
	private PasswordEncoderService passwordEncoderService;
	private PersonMailSenderService personMailSenderService;
	
	

	@Override
	public List<GetAllLaborantResponse> getAll() {
		
		List<GetAllLaborantResponse> laborantResponseList = laborantRepository.findAll().stream()
				.map(laborant -> modelMapperService.forResponse().map(laborant, GetAllLaborantResponse.class)).collect(Collectors.toList());
		
		return laborantResponseList;
	}
	
	@Override
	public GetLaborantResponse getById(int id) {
		
		Laborant target = laborantRepository.findById(id).orElseThrow();
		
		GetLaborantResponse laborantResponse = modelMapperService.forResponse().map(target, GetLaborantResponse.class);
		
		return laborantResponse;
		
	}

	@Override
	public void add(AddLaborantRequest addLaborantRequest) {
		
		laborantBusinessRulesService.checkEmailIfExistsBefore(addLaborantRequest.getEmail());
		laborantBusinessRulesService.checkUsernameIfExistsBefore(addLaborantRequest.getUsername());
		laborantBusinessRulesService.checkPasswordFieldsIfMatches(addLaborantRequest.getPassword(), addLaborantRequest.getConfirmPassword());
		
		Laborant laborant = modelMapperService.forRequest().map(addLaborantRequest, Laborant.class);
		
		laborant.setHospitalIdentityNumber(generateRandomNumber());
		
		String encodedPassword = passwordEncoderService.encodePassword(laborant.getPassword());
		laborant.setPassword(encodedPassword);

		laborantRepository.save(laborant);
		
		personMailSenderService.accountCreatedMessage(laborant.getEmail());

	}

	@Override
	public void updateUsername(UpdateLaborantUsernameRequest updateLaborantUsernameRequest) {
		
		laborantRepository.findById(updateLaborantUsernameRequest.getId()).orElseThrow();
		
		laborantBusinessRulesService.checkUsernameIfExistsBefore(updateLaborantUsernameRequest.getUsername());
		
		laborantRepository.updateUsername(updateLaborantUsernameRequest.getId(), updateLaborantUsernameRequest.getUsername());
		
	}

	@Override
	public void updatePassword(UpdateLaborantPasswordRequest updateLaborantPasswordRequest) {
		
		laborantBusinessRulesService.checkPasswordFieldsIfMatches(updateLaborantPasswordRequest.getPassword(), updateLaborantPasswordRequest.getConfirmPassword());
		
		String encodedNewPassword = passwordEncoderService.encodePassword(updateLaborantPasswordRequest.getPassword());
		
		laborantRepository.updatePassword(updateLaborantPasswordRequest.getId(),encodedNewPassword );
	}

	@Override
	public boolean checkPersonByEmail(String email) {
		
		boolean isExists = laborantRepository.existsByEmail(email);
		
		return isExists;
	}

	@Override
	public boolean checkPersonByUsername(String username) {
		
		boolean isExists = laborantRepository.existsByUsername(username);
		
		return isExists;
		
	}
	
	private String generateRandomNumber() {
		
		int randomNumber = new Random().nextInt(1000000)+1000000;
		
		return Integer.toString(randomNumber);
	}
	
	
}
