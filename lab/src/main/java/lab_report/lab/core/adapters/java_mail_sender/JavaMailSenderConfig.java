package lab_report.lab.core.adapters.java_mail_sender;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class JavaMailSenderConfig {
	
	private Environment environment;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	  
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername(environment.getProperty("spring.mail.username"));
	    mailSender.setPassword(environment.getProperty("spring.mail.password"));
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	@Bean
	public SimpleMailMessage simpleMailMessage() { 
		
		return new SimpleMailMessage();
	}

}
