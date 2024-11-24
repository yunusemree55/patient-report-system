package lab_report.lab.business.responses.patient_responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPatientResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;

}
