package lab_report.lab.business.requests.laborabt_requests;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLaborantRequest {
	
	@NotNull
	@Length(min = 3)
	private String firstName;
	
	@NotNull
	@Length(min = 2)
	private String lastName;
	
	@NotNull
	@Length(min = 3)
	private String username;
	
	@Email(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;

}
