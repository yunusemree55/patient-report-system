package lab_report.lab.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lab_report.lab.entities.concretes.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{
	
	boolean existsStatusByName(String name);
}
