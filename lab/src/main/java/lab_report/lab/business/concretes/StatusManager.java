package lab_report.lab.business.concretes;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.StatusService;
import lab_report.lab.business.business_rules.status_rules.StatusBusinessRulesService;
import lab_report.lab.business.requests.status_requests.AddStatusRequest;
import lab_report.lab.core.utilities.mappers.model_mapper.ModelMapperService;
import lab_report.lab.data_access.abstracts.StatusRepository;
import lab_report.lab.entities.concretes.Status;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusManager implements StatusService {
	
	private StatusRepository statusRepository;
	private ModelMapperService modelMapperService;
	private StatusBusinessRulesService statusBusinessRulesService;
	
	@Override
	public void add(AddStatusRequest addStatusRequest) {

		statusBusinessRulesService.checkStatusNameIfExistsBefore(addStatusRequest.getName());
		
		Status status = modelMapperService.forRequest().map(addStatusRequest, Status.class);
		
		statusRepository.save(status);
		 
	}


	@Override
	public boolean checkStatusByName(String name) {
		
		boolean isExists = statusRepository.existsStatusByName(name);
		
		return isExists;
		 
		
	}

}
