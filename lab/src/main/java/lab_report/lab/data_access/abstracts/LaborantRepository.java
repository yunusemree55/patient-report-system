package lab_report.lab.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lab_report.lab.entities.concretes.Laborant;

public interface LaborantRepository extends JpaRepository<Laborant, Integer> {

}
