package friendsbets.core.sb.exceptions;

import org.hibernate.exception.JDBCConnectionException;

public class DatabaseUnavailableException  extends ResourceUnavailableException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseUnavailableException(JDBCConnectionException ex)  {
		// TODO Auto-generated constructor stub
	}

}
