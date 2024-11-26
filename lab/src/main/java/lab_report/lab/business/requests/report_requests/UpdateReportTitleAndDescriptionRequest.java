package lab_report.lab.business.requests.report_requests;

import jakarta.validation.constraints.NotBlank;
import lab_report.lab.core.utilities.constants.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportTitleAndDescriptionRequest {
	
	private int id;
	
	@NotBlank(message = ValidationConstants.notNull)
	private String diagnosisTitle;
	
	@NotBlank(message = ValidationConstants.notNull)
	private String description;

}
