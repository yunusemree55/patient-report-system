package lab_report.lab.business.responses.laborant_responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLaborantResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String hospitalIdentityNumber;

}
