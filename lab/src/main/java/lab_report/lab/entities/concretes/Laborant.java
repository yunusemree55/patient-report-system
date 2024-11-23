package lab_report.lab.entities.concretes;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "laborants")
public class Laborant extends Person<Integer>{
	
	@Column(name = "hospitalIdentityNumber",unique = true,length = 7)
	private UUID hospitalIdentityNumber; 
	 
 
} 
