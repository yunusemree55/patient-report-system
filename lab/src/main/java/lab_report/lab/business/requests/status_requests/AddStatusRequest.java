package lab_report.lab.business.requests.status_requests;

import jakarta.validation.constraints.NotBlank;
import lab_report.lab.core.utilities.constants.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStatusRequest {
	
	@NotBlank(message = ValidationConstants.notBlank)
	private String name;

}
