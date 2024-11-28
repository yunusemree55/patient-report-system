package lab_report.lab.business.abstracts;

import java.util.List;

import lab_report.lab.business.requests.report_requests.AddReportRequest;
import lab_report.lab.business.requests.report_requests.UpdateReportTitleAndDescriptionRequest;
import lab_report.lab.business.responses.report_responses.GetAllReportResponse;
import lab_report.lab.business.responses.report_responses.GetReportResponse;

public interface ReportService {
	
	List<GetAllReportResponse> getAll();
	List<GetAllReportResponse> getAllByCreatedTime();
	List<GetAllReportResponse> getAllActiveReports();
	List<GetAllReportResponse> getAllPassiveReports();
	GetReportResponse getById(int id);
	
	void add(AddReportRequest addReportRequest);
	void updateTitleAndDescription(UpdateReportTitleAndDescriptionRequest updateReportTitleAndDescriptionRequest);
	void delete(int id);

}
