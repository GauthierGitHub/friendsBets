package exceptions;

import models.FbsBet;
import models.FbsGroup;
import models.FbsMatch;
import models.FbsMessage;
import models.FbsUser;

public class SqlNotFoundException extends FriendsBetsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SqlNotFoundException(Exception e, FbsBet b) {
		System.out.println("Unknow bet.");
	}

	public SqlNotFoundException(Exception e, FbsUser u) {
		System.out.println("Unknow user " + u.getNickname() + ".");
	}

	public SqlNotFoundException(Exception e, String email) {
		System.out.println("Uncorrect user mail or password ");
	}

	public SqlNotFoundException(Exception e, FbsMessage m) {
		System.out.println("Message not found");
	}

	public SqlNotFoundException(Exception e, FbsMatch m) {
		System.out.println("Match not found in database");
	}

	public SqlNotFoundException(Exception e, FbsGroup g) {
		System.out.println("Group not found.");
	}

	public SqlNotFoundException(Exception e, int id) {
		System.out.println("Id not found :" + id);
	}

}
