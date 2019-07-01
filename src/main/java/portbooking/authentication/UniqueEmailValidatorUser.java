package portbooking.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import portbooking.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidatorUser implements ConstraintValidator<UniqueEmailUser, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueEmailUser constraintAnnotation) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !userRepository.existsByEmail(email);
	}

}