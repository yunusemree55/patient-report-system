package lab_report.lab.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.LaborantService;
import lab_report.lab.business.business_rules.laborant_rules.LaborantBusinessRulesService;
import lab_report.lab.business.requests.laborabt_requests.AddLaborantRequest;
import lab_report.lab.business.responses.laborant_responses.GetAllLaborantResponse;
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

	@Override
	public List<GetAllLaborantResponse> getAll() {
		
		List<GetAllLaborantResponse> laborantResponseList = laborantRepository.findAll().stream()
				.map(laborant -> modelMapperService.forResponse().map(laborant, GetAllLaborantResponse.class)).collect(Collectors.toList());
		
		return laborantResponseList;
	}

	@Override
	public void add(AddLaborantRequest addLaborantRequest) {
		
		laborantBusinessRulesService.checkPasswordFieldsIfMatches(addLaborantRequest.getPassword(), addLaborantRequest.getConfirmPassword());
		
		Laborant laborant = modelMapperService.forRequest().map(addLaborantRequest, Laborant.class);

		laborantRepository.save(laborant);

	}

}
