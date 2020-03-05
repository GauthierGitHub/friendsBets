package friendsbets.core.sb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ForbiddenValueValidator implements ConstraintValidator<ForbiddenValue, String> {

	private String value;

	public void initialize(ForbiddenValue parameters) {
		value = parameters.value();
	}
	
	@Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object == null)
            return true;
        return !object.toLowerCase().equals(value.toLowerCase());
    }
}