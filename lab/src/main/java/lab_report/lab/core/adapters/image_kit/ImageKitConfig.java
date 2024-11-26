package lab_report.lab.core.adapters.image_kit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.imagekit.sdk.ImageKit;

@Configuration
public class ImageKitConfig {
	
	@Bean
	public ImageKit imageKit() {
		
		ImageKit imageKit = ImageKit.getInstance();
		
		imageKit.setConfig(new io.imagekit.sdk.config.Configuration(
				"public_gPzGvFsxmKotbWoxyCnVcu3sL28=", 
				"private_Ty12BZU5gPgInBvjU3Tf8b2O7SA=", 
				"https://ik.imagekit.io/5j7pnihhg"));
		
		
		return imageKit;
		
	}

}
