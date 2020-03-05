package friendsbets.core.sb.validators;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import friendsbets.core.sb.validators.Interval.List;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = IntervalValidator.class)
@Documented
@Repeatable(List.class)
public @interface Interval {
    String message() default "start must be before end";
    
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
    	Interval[] value();
    }
}