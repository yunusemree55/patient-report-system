package lab_report.lab.business.abstracts;

import java.util.List;

import lab_report.lab.business.requests.patient_requests.AddPatientRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientPasswordRequest;
import lab_report.lab.business.requests.patient_requests.UpdatePatientUsernameRequest;
import lab_report.lab.business.responses.patient_responses.GetAllPatientResponse;
import lab_report.lab.business.responses.patient_responses.GetPatientResponse;

public interface PatientService extends PersonService{
	
	List<GetAllPatientResponse> getAll();
	List<GetAllPatientResponse> getByFirstNameAndLastName(String firstName,String lastName);
	GetPatientResponse getById(int id);
	GetPatientResponse getByIdentityNumber(String identityNumber);
	
	boolean checkPatientByIdentityNumber(String identityNumber);
	
	void add(AddPatientRequest addPatientRequest);
	void updateUsername(UpdatePatientUsernameRequest updatePatientUsernameRequest);
	void updatePassword(UpdatePatientPasswordRequest updatePatientPasswordRequest);

}
