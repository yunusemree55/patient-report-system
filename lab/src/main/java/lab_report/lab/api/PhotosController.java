package lab_report.lab.api;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lab_report.lab.business.abstracts.PhotoService;
import lab_report.lab.business.requests.photo_requests.AddPhotoRequest;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/photos")
public class PhotosController {
	
	private PhotoService photoService;
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(AddPhotoRequest addPhotoRequest) throws IOException {
		
		photoService.add(addPhotoRequest);
		
	}

}
