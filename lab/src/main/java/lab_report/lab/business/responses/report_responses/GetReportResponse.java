package lab_report.lab.business.responses.report_responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReportResponse {

	private int id;
	private String laborantFirstName;
	private String laborantLastName;
	private String patientFirstName;
	private String patientLastName;
	private String documentId;
	private String patientIdentityNumber;
	private String diagnosisTitle;
	private String description;
	private String src;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdAt;

}
