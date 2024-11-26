package lab_report.lab.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import lab_report.lab.entities.concretes.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Report r SET r.diagnosisTitle = :diagnosisTitle, r.description = :description, r.updatedAt = CURRENT_TIMESTAMP WHERE r.id = :id")
	void updateTitleAndDescription(@Param(value = "id") int id,@Param(value = "diagnosisTitle") String diagnosisTitle,@Param(value = "description") String description);

}
 