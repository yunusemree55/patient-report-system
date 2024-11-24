package lab_report.lab.core.adapters.spring_security_crypto;

public interface PasswordEncoderService {
	
	String encodePassword(String rawPassword);
	boolean isMatches(String rawPassword, String encodedPassword);

}
