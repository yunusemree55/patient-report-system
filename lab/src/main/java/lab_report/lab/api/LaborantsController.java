package lab_report.lab.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lab_report.lab.business.abstracts.LaborantService;
import lab_report.lab.business.requests.laborabt_requests.AddLaborantRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantPasswordRequest;
import lab_report.lab.business.requests.laborabt_requests.UpdateLaborantUsernameRequest;
import lab_report.lab.business.responses.laborant_responses.GetAllLaborantResponse;
import lab_report.lab.business.responses.laborant_responses.GetLaborantResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/laborants")
public class LaborantsController {
	
	private LaborantService laborantService;
	
	@GetMapping("/all")
	public List<GetAllLaborantResponse> getAll(){
		
		return laborantService.getAll();
	}
	
	@GetMapping("/name")
	public List<GetAllLaborantResponse> getByFirstNameAndLastName(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName){
		
		return laborantService.getByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/{id}")
	public GetLaborantResponse getById(@PathVariable int id) {
		
		return laborantService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddLaborantRequest addLaborantRequest) {
		
		laborantService.add(addLaborantRequest);
	}
	
	@PutMapping("/update-username")
	public void updateUsername(@RequestBody @Valid UpdateLaborantUsernameRequest updateLaborantUsernameRequest) {
		
		laborantService.updateUsername(updateLaborantUsernameRequest);
		
	}
	
	@PutMapping("/update-password")
	public void updatePassword(@RequestBody @Valid UpdateLaborantPasswordRequest updateLaborantPasswordRequest) {
		
		laborantService.updatePassword(updateLaborantPasswordRequest);
	} 
 
}
