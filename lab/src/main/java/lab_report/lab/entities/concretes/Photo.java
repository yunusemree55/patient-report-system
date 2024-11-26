package lab_report.lab.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lab_report.lab.core.entities.MyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "photos")
public class Photo extends MyEntity<Integer>{
	
	private String src;
	
	@OneToOne
	@JoinColumn(name = "reportId")
	private Report report;
}
