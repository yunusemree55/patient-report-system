package lab_report.lab.business.business_rules.person_rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.PersonService;
import lab_report.lab.core.utilities.constants.ExceptionConstants;
import lab_report.lab.core.utilities.exceptions.BusinessException;

@Service
public class PersonBusinessRulesManager<T extends PersonService> implements PersonBusinessRulesService{
	
	@Lazy
	@Autowired
	private T personService;

	@Override
	public void checkPasswordFieldsIfMatches(String password, String confirmPassword) {
		
		boolean isMatches = password.equals(confirmPassword);
		
		if(isMatches == false) {
			
			throw new BusinessException(ExceptionConstants.passwordExceptionMessage);
		}
		
	}

	@Override
	public void checkEmailIfExistsBefore(String email) {
		
		boolean isExists = personService.checkPersonByEmail(email);
		if(isExists) {
			
			throw new BusinessException(ExceptionConstants.emailExistsExceptionMessage); 
		}
		
	}

	@Override 
	public void checkUsernameIfExistsBefore(String username) {
		
		boolean isExists = personService.checkPersonByUsername(username);
		
		if(isExists) {
			
			throw new BusinessException(ExceptionConstants.usernameExistsExceptionMessage);
			
		}
	}

}
