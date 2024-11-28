package lab_report.lab.business.responses.patient_responses;

import java.util.List;

import lab_report.lab.business.responses.report_responses.GetReportResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPatientResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String statusName;
	
	private List<GetReportResponse> reports;

}
