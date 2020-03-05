package friendsbets.core.sb.exceptions;

/**
 * Exception throw when an external resource can't be accessed.
 * @author andre
 */
public class ResourceUnavailableException extends FriendsBetsException {

	private static final long serialVersionUID = 1L;

	public ResourceUnavailableException() {
	}

	public ResourceUnavailableException(String message) {
		super(message);
	}

	public ResourceUnavailableException(Throwable cause) {
		super(cause);
	}

	public ResourceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceUnavailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
