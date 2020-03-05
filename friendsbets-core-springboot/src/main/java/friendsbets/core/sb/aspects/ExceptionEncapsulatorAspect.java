package friendsbets.core.sb.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.exceptions.DatabaseUnavailableException;
import friendsbets.exceptions.JuniorDeveloperException;

@Component
@Aspect
public class ExceptionEncapsulatorAspect {

	private static final Logger logger = Logger.getLogger(ExceptionEncapsulatorAspect.class);

	@Around("@annotation(graze.aspects.EncapsulateException)")
	public Object exceptionEncapsulatorAdvice(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (JDBCConnectionException ex) {
			return new DatabaseUnavailableException(ex);
		} catch (HibernateException ex) {
			return new JuniorDeveloperException(ex);
		}
	}

	@AfterThrowing(pointcut = "execution(* graze.services.*.*(..))", throwing = "e")
	public void nonEncapsulatedExceptionAdvice(Exception e) {
		if (!(e instanceof FriendsBetsException))
			logger.warn("exception " + e.getClass().getName()
					+ "should have been encapsulated in a GrazeException. Please fill a bug.");
	}

}
