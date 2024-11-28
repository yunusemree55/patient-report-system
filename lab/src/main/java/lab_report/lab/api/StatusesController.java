package lab_report.lab.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lab_report.lab.business.abstracts.StatusService;
import lab_report.lab.business.requests.status_requests.AddStatusRequest;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/statuses")
public class StatusesController {
	
	private StatusService statusService;
	
	@PostMapping("/add")
	public void add(@RequestBody @Valid AddStatusRequest addStatusRequest) {
		
		statusService.add(addStatusRequest);
	}

}
