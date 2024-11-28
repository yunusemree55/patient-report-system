package lab_report.lab.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.ReportService;
import lab_report.lab.business.requests.report_requests.AddReportRequest;
import lab_report.lab.business.requests.report_requests.UpdateReportTitleAndDescriptionRequest;
import lab_report.lab.business.responses.report_responses.GetAllReportResponse;
import lab_report.lab.business.responses.report_responses.GetReportResponse;
import lab_report.lab.core.utilities.mappers.model_mapper.ModelMapperService;
import lab_report.lab.data_access.abstracts.ReportRepository;
import lab_report.lab.entities.concretes.Report;
import lab_report.lab.entities.concretes.Status;
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
	public List<GetAllReportResponse> getAllByCreatedTime() {

		List<GetAllReportResponse> reportResponseList = reportRepository.findByOrderByCreatedAtDesc().stream()
				.map(report -> modelMapperService.forResponse().map(report, GetAllReportResponse.class)).collect(Collectors.toList());
		 
		
		return reportResponseList;
	}
	
	@Override
	public List<GetAllReportResponse> getAllActiveReports() {
		
		List<GetAllReportResponse> reportResponseList = reportRepository.findReportsByStatusIdEquals(1).stream()
				.map(report -> modelMapperService.forResponse().map(report, GetAllReportResponse.class)).collect(Collectors.toList());
		
		return reportResponseList;
	}

	@Override
	public List<GetAllReportResponse> getAllPassiveReports() {
		
		List<GetAllReportResponse> reportResponseList = reportRepository.findReportsByStatusIdEquals(2).stream()
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
		report.setDocumentId(generateUuidForReport());
		report.setStatus(new Status());
		report.getStatus().setId(1);
		
		reportRepository.save(report);
		
	}

	@Override
	public void updateTitleAndDescription(
			UpdateReportTitleAndDescriptionRequest updateReportTitleAndDescriptionRequest) {
		
		reportRepository.updateTitleAndDescription(updateReportTitleAndDescriptionRequest.getId(), 
				updateReportTitleAndDescriptionRequest.getDiagnosisTitle(), 
				updateReportTitleAndDescriptionRequest.getDescription());
		
	}

	@Override
	public void delete(int id) {
		
		reportRepository.deleteReportById(id);
		
	}
	
	private UUID generateUuidForReport() {
		
		return UUID.randomUUID();
	}

	

	

}
