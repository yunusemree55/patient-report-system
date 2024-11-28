package lab_report.lab.business.requests.patient_requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lab_report.lab.core.utilities.constants.PersonValidationConstants;
import lab_report.lab.core.utilities.constants.ProjectConstants;
import lab_report.lab.core.utilities.constants.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPatientRequest {
	
	@NotBlank(message = ValidationConstants.notBlank)
	@Length(min = 3,message = PersonValidationConstants.firstNameLength)
	private String firstName;
	
	@NotBlank(message = ValidationConstants.notBlank)
	@Length(min = 2,message = PersonValidationConstants.lastNameLength)
	private String lastName;
	
	@NotNull(message = ValidationConstants.notBlank)
	@Length(min = 3,message = PersonValidationConstants.usernameLength)
	private String username;
	
	@Email(regexp = ProjectConstants.emailRegex)
	@NotBlank(message = ValidationConstants.notBlank)
	private String email;
	
	@NotBlank(message = ValidationConstants.notBlank)
	@Length(min = 11,max = 11,message = PersonValidationConstants.identityNumberLength)
	private String identityNumber;
	
	@NotBlank(message = ValidationConstants.notBlank)
	@Length(min = 3,message = PersonValidationConstants.passwordLength)
	private String password;
	
	@NotBlank(message = ValidationConstants.notBlank)
	private String confirmPassword;

}
