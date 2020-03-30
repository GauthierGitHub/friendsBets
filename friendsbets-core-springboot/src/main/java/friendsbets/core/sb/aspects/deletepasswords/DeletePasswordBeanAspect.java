package friendsbets.core.sb.aspects.deletepasswords;

import java.util.Set;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import friendsbets.core.sb.models.User;

@Component
@Aspect
public class DeletePasswordBeanAspect {

	@AfterReturning(pointcut="@annotation(friendsbets.core.sb.aspects.deletepasswords.DeletePasswords)", returning="users")
	public void deletePasswords(Set<User> users) {
		users.stream().forEach(x -> x.setPassword(null));
	}
	
	@AfterReturning(pointcut="@annotation(friendsbets.core.sb.aspects.deletepasswords.DeletePassword)", returning="user")
	public void deletePassword(User user) {
		user.setPassword(null);
	}
}
/*
@Around("@annotation(friendsbets.core.sb.aspects.EncapsulateException)")
public Object exceptionEncapsulatorAdvice(ProceedingJoinPoint pjp) throws Throwable {
	try {
		return pjp.proceed();
	} catch (JDBCConnectionException ex) {
		return new DatabaseUnavailableException(ex);
	} catch (HibernateException ex) {
		return new JuniorDeveloperException(ex);
	}
}

@AfterThrowing(pointcut = "execution(* friendsbets.core.sb.services.*.*(..))", throwing = "e")
public void nonEncapsulatedExceptionAdvice(Exception e) {
	if (!(e instanceof FriendsBetsException))
		logger.warn("exception " + e.getClass().getName()
				+ "should have been encapsulated in a FriendsBetsException. Please fill a bug.");
*/
