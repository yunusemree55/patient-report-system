package lab_report.lab.core.adapters.image_kit;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageKitService {
	
	String upload(MultipartFile file) throws IOException;

}
