package portbooking.authentication;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = UniqueEmailValidatorUser.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailUser {

	String message() default "Email already exists!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
