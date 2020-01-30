package exceptions;

import models.FriendsBetsBet;
import models.FriendsBetsGroup;
import models.FriendsBetsMatch;
import models.FriendsBetsMessage;
import models.FriendsBetsUser;

public class SqlNotFoundException extends FriendsBetsException {

	public SqlNotFoundException(Exception e, FriendsBetsBet b) {
		System.out.println("Unknow bet.");
	}

	public SqlNotFoundException(Exception e, FriendsBetsUser u) {
		System.out.println("Unknow user " + u.getNickname() + ".");
	}

	public SqlNotFoundException(Exception e, String email) {
		System.out.println("Uncorrect user mail or password ");
	}

	public SqlNotFoundException(Exception e, FriendsBetsMessage m) {
		System.out.println("Message not found");
	}

	public SqlNotFoundException(Exception e, FriendsBetsMatch m) {
		System.out.println("Match not found in database");
	}

	public SqlNotFoundException(Exception e, FriendsBetsGroup g) {
		System.out.println("Group not found.");
	}

}
