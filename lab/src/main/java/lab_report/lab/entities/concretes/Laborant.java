package lab_report.lab.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String hospitalIdentityNumber;
	 
	@OneToMany(mappedBy = "laborant")
	private List<Report> reports;
	
	@ManyToOne()
	@JoinColumn(name = "statusId")
	private Status status;
} 
