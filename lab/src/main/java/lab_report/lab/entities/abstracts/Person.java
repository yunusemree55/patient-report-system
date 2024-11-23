package lab_report.lab.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lab_report.lab.core.entities.MyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class Person<T> extends MyEntity<T>{
	
	@Column(name = "username",unique = true)
	private String username;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

} 
