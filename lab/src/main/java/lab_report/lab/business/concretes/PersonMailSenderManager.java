package lab_report.lab.business.concretes;

import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.PersonMailSenderService;
import lab_report.lab.core.utilities.constants.MailConstants;
import lab_report.lab.core.utilities.mail.EmailDetail;
import lab_report.lab.core.utilities.mail.EmailService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonMailSenderManager implements PersonMailSenderService{
	
	private EmailService emailService;
	
	@Override
	public void accountCreatedMessage(String email) {
		
		EmailDetail emailDetail = new EmailDetail();
		
		emailDetail.setTo(email);
		emailDetail.setSubject(MailConstants.accountCreatedSubject);
		emailDetail.setText(MailConstants.accountCreatedText);
		
		emailService.sendEmail(emailDetail);		
				
	}

}
