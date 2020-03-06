package friendsbets.core.sb.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import friendsbets.core.sb.exceptions.DatabaseUnavailableException;
import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.exceptions.JuniorDeveloperException;

@Component
@Aspect
public class ExceptionEncapsulatorAspect {

	private static final Logger logger = Logger.getLogger(ExceptionEncapsulatorAspect.class);

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
	}

}
