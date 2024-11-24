package lab_report.lab.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

}
