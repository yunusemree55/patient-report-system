package lab_report.lab.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.ReportService;
import lab_report.lab.business.requests.report_requests.AddReportRequest;
import lab_report.lab.business.responses.report_responses.GetAllReportResponse;
import lab_report.lab.business.responses.report_responses.GetReportResponse;
import lab_report.lab.core.utilities.mappers.model_mapper.ModelMapperService;
import lab_report.lab.data_access.abstracts.ReportRepository;
import lab_report.lab.entities.concretes.Report;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportManager implements ReportService{
	
	private ReportRepository reportRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllReportResponse> getAll() {
		
		List<GetAllReportResponse> reportResponseList = reportRepository.findAll().stream()
				.map(report -> modelMapperService.forResponse().map(report, GetAllReportResponse.class)).collect(Collectors.toList());
		
		return reportResponseList;
	}

	@Override
	public GetReportResponse getById(int id) {

		Report target = reportRepository.findById(id).orElseThrow();
		
		GetReportResponse reportResponse = modelMapperService.forResponse().map(target, GetReportResponse.class);
		
		return reportResponse;
		
	}

	@Override
	public void add(AddReportRequest addReportRequest) {
		
		Report report = modelMapperService.forRequest().map(addReportRequest, Report.class);
		
		reportRepository.save(report);
		
	}

}
