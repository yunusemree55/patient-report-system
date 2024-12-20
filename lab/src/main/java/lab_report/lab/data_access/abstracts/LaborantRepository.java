package lab_report.lab.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import lab_report.lab.entities.concretes.Laborant;

public interface LaborantRepository extends JpaRepository<Laborant, Integer>,PersonRepository<Laborant> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Laborant l SET l.username = :username, l.updatedAt = CURRENT_TIMESTAMP WHERE l.id = :id")
	void updateUsername(@Param(value = "id") int id,@Param(value = "username") String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Laborant l SET l.password = :password ,l.updatedAt = CURRENT_TIMESTAMP WHERE l.id = :id")
	void updatePassword(@Param(value = "id") int id, @Param(value = "password") String password);

}
