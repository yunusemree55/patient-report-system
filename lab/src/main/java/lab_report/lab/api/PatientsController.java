package lab_report.lab.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lab_report.lab.business.abstracts.PatientService;
import lab_report.lab.business.requests.patient_requests.AddPatientRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientPasswordRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientUsernameRequest;
import lab_report.lab.business.responses.patient_responses.GetAllPatientResponse;
import lab_report.lab.business.responses.patient_responses.GetPatientResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientsController {
	
	private PatientService patientService;
	
	@GetMapping("/all")
	public List<GetAllPatientResponse> getAll(){
		
		return patientService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetPatientResponse getById(@PathVariable int id) {
		
		return patientService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddPatientRequest addPatientRequest) {
		
		patientService.add(addPatientRequest);
	}
	
	@PutMapping("/update-username")
	public void updateUsername(@RequestBody @Valid UpdatePatientUsernameRequest updatePatientUsernameRequest) {
		
		patientService.updateUsername(updatePatientUsernameRequest);
	}
	
	@PutMapping("/update-password")
	public void updatePassword(@RequestBody @Valid UpdatePatientPasswordRequest updatePatientPasswordRequest) {
		
		patientService.updatePassword(updatePatientPasswordRequest);
	}
	

}
