package exceptions;

import org.hibernate.exception.JDBCConnectionException;

public class DatabaseUnavailableException extends FriendsBetsException {

	public DatabaseUnavailableException(JDBCConnectionException ex) {
		// TODO Auto-generated constructor stub
	}

}
