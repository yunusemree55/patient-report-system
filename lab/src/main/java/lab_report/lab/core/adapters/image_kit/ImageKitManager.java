package lab_report.lab.core.adapters.image_kit;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;

@Service
public class ImageKitManager implements ImageKitService{

	@Override
	public String upload(MultipartFile file) throws IOException {
		
		FileCreateRequest fileCreateRequest =new FileCreateRequest(file.getBytes(), "sample_base64_image.jpg");

			try {
				
				Result result = ImageKit.getInstance().upload(fileCreateRequest);
				return result.getUrl();
				
			} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
						| TooManyRequestsException | UnauthorizedException e) {
					
				e.printStackTrace();
				return null;
			}
		
	}

}
