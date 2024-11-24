package lab_report.lab;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lab_report.lab.core.utilities.constants.ExceptionConstants;
import lab_report.lab.core.utilities.exceptions.BusinessException;
import lab_report.lab.core.utilities.exceptions.ProblemDetail;
import lab_report.lab.core.utilities.exceptions.ValidationProblemDetail;

@SpringBootApplication
@RestControllerAdvice
public class LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail businessException(BusinessException businessException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(businessException.getMessage());
		
		return problemDetail;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentValidException) {
		
		ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail();
		validationProblemDetail.setMessage(ExceptionConstants.validationExceptionMessage);
		
		validationProblemDetail.setErrors(new HashMap<String, String>());
		
		for (FieldError fieldError : methodArgumentValidException.getBindingResult().getFieldErrors()) {
			
			validationProblemDetail.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		return validationProblemDetail;
		
	}
	
	@ExceptionHandler
	public ProblemDetail noSuchElementException(NoSuchElementException noSuchElementException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(ExceptionConstants.noSuchElementExceptionMessage);
		
		return problemDetail;
		
	}

}
