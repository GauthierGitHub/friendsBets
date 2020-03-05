package friendsbets.core.sb.utils;

import java.util.function.Supplier;

import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;

import friendsbets.core.sb.exceptions.DatabaseUnavailableException;
import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.exceptions.JuniorDeveloperException;

/**
 * Helper class encapsulating HibernateException into friendsbets specific ones.
 * @author andre
 */
public class HibernateExceptionEncapsulator {

	public static void run(Runnable m) throws FriendsBetsException {
		try {
			m.run();
		} catch(JDBCConnectionException ex) {
			throw new DatabaseUnavailableException(ex);
		} catch(HibernateException ex) {
			throw new JuniorDeveloperException(ex);
		}
	}

	public static <R> R run(Supplier<R> m) throws FriendsBetsException {
		try {
			return m.get();
		} catch(JDBCConnectionException ex) {
			throw new DatabaseUnavailableException(ex);
		} catch(HibernateException ex) {
			throw new JuniorDeveloperException(ex);
		}
	}
	
	public static FriendsBetsException encapsulate(HibernateException e) {
		try {
			throw e;
		} catch(JDBCConnectionException ex) {
			return new DatabaseUnavailableException(ex);
		} catch(HibernateException ex) {
			return new JuniorDeveloperException(ex);
		}
	}
	
}
