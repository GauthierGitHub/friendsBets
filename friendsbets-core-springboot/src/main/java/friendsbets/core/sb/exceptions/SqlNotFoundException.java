package friendsbets.core.sb.exceptions;

import friendsbets.core.sb.models.Bet;
import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.Match;
import friendsbets.core.sb.models.Message;
import friendsbets.core.sb.models.User;

public class SqlNotFoundException extends FriendsBetsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SqlNotFoundException(Exception e, Bet b) {
		System.out.println("Unknow bet.");
	}

	public SqlNotFoundException(Exception e, User u) {
		System.out.println("Unknow user " + u.getNickname() + ".");
	}

	public SqlNotFoundException(Exception e, String email) {
		System.out.println("Uncorrect user mail or password ");
	}

	public SqlNotFoundException(Exception e, Message m) {
		System.out.println("Message not found");
	}

	public SqlNotFoundException(Exception e, Match m) {
		System.out.println("Match not found in database");
	}

	public SqlNotFoundException(Exception e, Group g) {
		System.out.println("Group not found.");
	}

	public SqlNotFoundException(Exception e, int id) {
		System.out.println("Id not found :" + id);
	}

}
