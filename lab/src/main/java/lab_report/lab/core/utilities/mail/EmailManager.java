package lab_report.lab.core.utilities.mail;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailManager implements EmailService{

	private SimpleMailMessage simpleMailMessage;
	private JavaMailSender mailSender;
	private Environment environment;

	@Override
	public void sendEmail(EmailDetail email) {
		
		simpleMailMessage.setFrom(environment.getProperty("spring.mail.username"));
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getText());
		
		mailSender.send(simpleMailMessage);
		
	}

}
