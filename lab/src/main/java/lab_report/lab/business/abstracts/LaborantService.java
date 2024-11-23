package lab_report.lab.business.abstracts;

import java.util.List;

import lab_report.lab.business.requests.laborabt_requests.AddLaborantRequest;
import lab_report.lab.business.responses.laborant_responses.GetAllLaborantResponse;

public interface LaborantService {
	
	List<GetAllLaborantResponse> getAll();
	
	void add(AddLaborantRequest addLaborantRequest);
	
	

}
