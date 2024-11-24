package lab_report.lab.core.adapters.spring_security_crypto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordEncoderManager implements PasswordEncoderService{
	
	private BCryptPasswordEncoder encoder;

	@Override
	public String encodePassword(String rawPassword) {
		
		String encodedPassword = encoder.encode(rawPassword);
		
		return encodedPassword;
		
	}

	@Override
	public boolean isMatches(String rawPassword, String encodedPassword) {
		
		boolean result = encoder.matches(rawPassword, encodedPassword);
		
		return result;
	}

}
