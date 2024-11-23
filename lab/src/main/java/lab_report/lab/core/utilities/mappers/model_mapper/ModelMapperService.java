package lab_report.lab.core.utilities.mappers.model_mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forRequest();
	ModelMapper forResponse();

}
