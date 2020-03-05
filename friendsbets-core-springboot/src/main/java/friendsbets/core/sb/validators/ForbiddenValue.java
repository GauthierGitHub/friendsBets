package friendsbets.core.sb.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import friendsbets.core.sb.validators.ForbiddenValue.List;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ForbiddenValueValidator.class)
@Documented
@Repeatable(List.class)
public @interface ForbiddenValue {
    String value();
    String message() default "value is forbbiden";
    
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD })
    @Retention(RUNTIME)
    @Documented
    @interface List {
    	ForbiddenValue[] value();
    }
}