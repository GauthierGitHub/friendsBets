package friendsbets.core.sb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import friendsbets.core.sb.models.User;

public class IntervalValidator implements ConstraintValidator<Interval, User> {

	

	public void initialize(Interval parameters) {
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO: Personnal validation
//	@Override
//    public boolean isValid(User u, ConstraintValidatorContext constraintContext) {
//        return u.getStart().isBefore(u.getEnd());
//    }
}