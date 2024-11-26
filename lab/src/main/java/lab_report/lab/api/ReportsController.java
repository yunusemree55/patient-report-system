package lab_report.lab.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lab_report.lab.business.abstracts.ReportService;
import lab_report.lab.business.requests.report_requests.AddReportRequest;
import lab_report.lab.business.requests.report_requests.UpdateReportTitleAndDescriptionRequest;
import lab_report.lab.business.responses.report_responses.GetAllReportResponse;
import lab_report.lab.business.responses.report_responses.GetReportResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reports")
public class ReportsController {
	
	private ReportService reportService;
	
	@GetMapping("/all")
	public List<GetAllReportResponse> getAll(){
		
		return reportService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetReportResponse getById(@PathVariable int id) {
		
		return reportService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody @Valid AddReportRequest addReportRequest) {
		
		reportService.add(addReportRequest);
	}
	
	@PutMapping("/update-report")
	public void updateTitleAndDescription(@RequestBody @Valid
			UpdateReportTitleAndDescriptionRequest updateReportTitleAndDescriptionRequest) {
		
		reportService.updateTitleAndDescription(updateReportTitleAndDescriptionRequest);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		reportService.delete(id);
		
	}

}
