package lab_report.lab.entities.concretes;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lab_report.lab.core.entities.MyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
public class Report extends MyEntity<Integer>{
	
	@Column(name = "documentId",unique = true)
	private UUID documentId;
	
	@Column(name = "diagnosisTitle")
	private String diagnosisTitle;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "laborantId")
	private Laborant laborant;
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@OneToOne(mappedBy = "report",cascade = CascadeType.ALL)
	private Photo photo;
	
	@ManyToOne()
	@JoinColumn(name = "statusId")
	private Status status;

}
