package lab_report.lab.business.responses.laborant_responses;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLaborantResponse {
	
	private String firstName;
	private String lastName;
	private UUID hospitalIdentityNumber;

}
