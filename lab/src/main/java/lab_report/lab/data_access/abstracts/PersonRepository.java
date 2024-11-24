package lab_report.lab.data_access.abstracts;

import lab_report.lab.entities.abstracts.Person;


public interface PersonRepository<T extends Person<?>>{
	
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);

}
