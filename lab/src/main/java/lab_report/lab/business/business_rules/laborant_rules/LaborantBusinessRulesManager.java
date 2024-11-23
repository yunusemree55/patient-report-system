package lab_report.lab.business.business_rules.laborant_rules;

import org.springframework.stereotype.Service;

import lab_report.lab.core.utilities.exceptions.BusinessException;

@Service
public class LaborantBusinessRulesManager implements LaborantBusinessRulesService{

	@Override
	public void checkPasswordFieldsIfMatches(String password, String confirmPassword) {
		
		boolean isMatches = password.contains(confirmPassword);
		
		if(!isMatches) {
			
			throw new BusinessException("Passwords are not matched");
		}
		
	}

}
