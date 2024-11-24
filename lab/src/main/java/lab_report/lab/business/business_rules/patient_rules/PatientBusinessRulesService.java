package lab_report.lab.business.business_rules.patient_rules;

import lab_report.lab.business.business_rules.person_rules.PersonBusinessRulesService;

public interface PatientBusinessRulesService extends PersonBusinessRulesService{
	
	void checkPatientNationalIdentityIfExistsBefore(String nationalIdentity);

}
