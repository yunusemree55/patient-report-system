package lab_report.lab.business.business_rules.person_rules;

public interface PersonBusinessRulesService {
	
	void checkPasswordFieldsIfMatches(String password,String confirmPassword);
	void checkEmailIfExistsBefore(String email);
	void checkUsernameIfExistsBefore(String username);

}
