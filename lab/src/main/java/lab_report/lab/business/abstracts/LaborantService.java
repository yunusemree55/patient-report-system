package lab_report.lab.business.abstracts;

import java.util.List;
import lab_report.lab.business.requests.laborabt_requests.AddLaborantRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantPasswordRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantUsernameRequest;
import lab_report.lab.business.responses.laborant_responses.GetAllLaborantResponse;
import lab_report.lab.business.responses.laborant_responses.GetLaborantResponse;

public interface LaborantService extends PersonService{
	
	List<GetAllLaborantResponse> getAll();
	GetLaborantResponse getById(int id);

	void add(AddLaborantRequest addPersonRequest);
	void updateUsername(UpdateLaborantUsernameRequest updatePersonUsernameRequest);
	void updatePassword(UpdateLaborantPasswordRequest updatePersonPasswordRequest);
}
