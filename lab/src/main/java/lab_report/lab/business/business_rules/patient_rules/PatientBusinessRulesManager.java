package lab_report.lab.business.business_rules.patient_rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.PatientService;
import lab_report.lab.business.business_rules.person_rules.PersonBusinessRulesManager;
import lab_report.lab.core.utilities.constants.ExceptionConstants;
import lab_report.lab.core.utilities.exceptions.BusinessException;

@Service
public class PatientBusinessRulesManager extends PersonBusinessRulesManager<PatientService> implements PatientBusinessRulesService{

	@Lazy
	@Autowired
	private PatientService patientService;
	
	@Override
	public void checkPatientNationalIdentityIfExistsBefore(String nationalIdentity) {
		
		boolean isExists = patientService.checkPatientByIdentityNumber(nationalIdentity);
		
		if(isExists) {
			
			throw new BusinessException(ExceptionConstants.identityNumberExistsException);
		}
		
	}
	

}
