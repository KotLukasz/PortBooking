
package portbooking.authentication;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = UniqueEmailValidatorPortOwner.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailPortOwner {

	String message() default "Email already exists!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
