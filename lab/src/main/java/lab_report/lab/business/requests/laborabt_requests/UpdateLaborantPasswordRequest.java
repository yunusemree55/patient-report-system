package lab_report.lab.business.requests.laborabt_requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lab_report.lab.core.utilities.constants.PersonValidationConstants;
import lab_report.lab.core.utilities.constants.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLaborantPasswordRequest {
	
	private int id;
	
	@NotBlank(message = ValidationConstants.notNull)
	@Length(min = 3,message = PersonValidationConstants.passwordLength)
	private String password;
	
	@NotBlank(message = ValidationConstants.notNull)
	private String confirmPassword;

}
