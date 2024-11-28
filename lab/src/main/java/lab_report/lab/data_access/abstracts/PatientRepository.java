package lab_report.lab.data_access.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import lab_report.lab.entities.concretes.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>, PersonRepository<Patient>{
	
	Optional<Patient> findByIdentityNumber(String identityNumber);
	
	@Modifying
	@Transactional
	@Query("UPDATE Patient p SET p.username = :username, p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
	void updateUsername(@Param(value = "id") int id,@Param(value = "username") String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Patient p SET p.password = :password ,p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
	void updatePassword(@Param(value = "id") int id, @Param(value = "password") String password);

	boolean existsByIdentityNumber(String identityNumber);

}
 