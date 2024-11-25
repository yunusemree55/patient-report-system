package lab_report.lab.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lab_report.lab.entities.abstracts.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Person<Integer>{
	
	@Column(name = "identityNumber",unique = true)
	private String identityNumber;
	
	@OneToMany(mappedBy = "patient")
	private List<Report> reports;

}
