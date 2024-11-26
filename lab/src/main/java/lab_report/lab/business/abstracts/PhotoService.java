package lab_report.lab.business.abstracts;

import java.io.IOException;

import lab_report.lab.business.requests.photo_requests.AddPhotoRequest;

public interface PhotoService {
	
	void add(AddPhotoRequest addPhotoRequest) throws IOException;

}
