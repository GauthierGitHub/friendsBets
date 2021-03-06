package exceptions;

import models.FbsMessage;

/**
 * Root exception for all graze-defined ones. 
 * @author andre / gauthier
 */
public class FriendsBetsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FriendsBetsException() {
	}

	public FriendsBetsException(String message) {
		super(message);
	}

	public FriendsBetsException(Throwable cause) {
		super(cause);
	}

	public FriendsBetsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FriendsBetsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}