package lab_report.lab.business.requests.photo_requests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPhotoRequest {
	
	private int reportId;
	private MultipartFile file;

}
