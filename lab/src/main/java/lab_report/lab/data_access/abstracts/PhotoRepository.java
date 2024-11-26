package lab_report.lab.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lab_report.lab.entities.concretes.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

}
