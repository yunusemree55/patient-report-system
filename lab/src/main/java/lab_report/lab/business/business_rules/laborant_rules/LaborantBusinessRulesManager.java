package lab_report.lab.business.business_rules.laborant_rules;


import org.springframework.stereotype.Service;

import lab_report.lab.business.abstracts.LaborantService;
import lab_report.lab.business.business_rules.person_rules.PersonBusinessRulesManager;

@Service
public class LaborantBusinessRulesManager extends PersonBusinessRulesManager<LaborantService> implements LaborantBusinessRulesService {
	
	

}
