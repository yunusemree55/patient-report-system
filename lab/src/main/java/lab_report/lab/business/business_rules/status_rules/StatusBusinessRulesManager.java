package lab_report.lab.business.business_rules.status_rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.StatusService;
import lab_report.lab.core.utilities.constants.ExceptionConstants;
import lab_report.lab.core.utilities.exceptions.BusinessException;

@Service
public class StatusBusinessRulesManager implements StatusBusinessRulesService{
	
	@Lazy
	@Autowired
	private StatusService statusService;

	@Override
	public void checkStatusNameIfExistsBefore(String name) {
		
		boolean isExists = statusService.checkStatusByName(name);
		
		if(isExists) {
			
			throw new BusinessException(ExceptionConstants.statusExistsException);
			
		}
		
	}
	
	

}
