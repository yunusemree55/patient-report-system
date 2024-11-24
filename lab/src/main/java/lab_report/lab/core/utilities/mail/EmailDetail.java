package lab_report.lab.core.utilities.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {
	
	private String to;
	private String subject;
	private String text;

}
