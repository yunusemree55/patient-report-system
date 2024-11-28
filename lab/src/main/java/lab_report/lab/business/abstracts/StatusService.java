package lab_report.lab.business.abstracts;

import lab_report.lab.business.requests.status_requests.AddStatusRequest;

public interface StatusService {
	
	boolean checkStatusByName(String name);
	
	void add(AddStatusRequest addStatusRequest);

}
