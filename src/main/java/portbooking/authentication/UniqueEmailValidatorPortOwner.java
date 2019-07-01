package portbooking.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import portbooking.repository.PortOwnerRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidatorPortOwner implements ConstraintValidator<UniqueEmailPortOwner, String> {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@Override
	public void initialize(UniqueEmailPortOwner constraintAnnotation) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !portOwnerRepository.existsByEmail(email);
	}

}