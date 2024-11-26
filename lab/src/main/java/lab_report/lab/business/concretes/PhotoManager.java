package lab_report.lab.business.concretes;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.PhotoService;
import lab_report.lab.business.requests.photo_requests.AddPhotoRequest;
import lab_report.lab.core.adapters.image_kit.ImageKitService;
import lab_report.lab.data_access.abstracts.PhotoRepository;
import lab_report.lab.entities.concretes.Photo;
import lab_report.lab.entities.concretes.Report;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PhotoManager implements PhotoService{
	
	private PhotoRepository photoRepository;
	private ImageKitService imageKitService;
	
	@Override
	public void add(AddPhotoRequest addPhotoRequest) throws IOException {
		
		String src = imageKitService.upload(addPhotoRequest.getFile());
		
		if(src != null) {
			
			Photo photo = new Photo();
			photo.setReport(new Report());
			photo.setSrc(src);
			photo.getReport().setId(addPhotoRequest.getReportId());
			
			
			photoRepository.save(photo);
		}
		
	}

}
