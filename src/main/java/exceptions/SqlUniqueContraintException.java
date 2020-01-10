package exceptions;

import models.FriendsBetsBet;
import models.FriendsBetsGroup;
import models.FriendsBetsMatch;
import models.FriendsBetsUser;

public class SqlUniqueContraintException extends Exception {

	public SqlUniqueContraintException(Exception e, FriendsBetsBet b) {
		System.out.println("Bet already done !");
	}

	public SqlUniqueContraintException(Exception e, FriendsBetsUser u) {
		System.out.println("User mail already register or nickname yet reserved");
	}

	public SqlUniqueContraintException(Exception e, FriendsBetsMatch m) {
		System.out.println("Match already writte in database");
	}

	public SqlUniqueContraintException(Exception e, FriendsBetsGroup g) {
		System.out.println("Same group already done !");
	}

	public SqlUniqueContraintException(Exception e, FriendsBetsGroup g, FriendsBetsUser u) {
		System.out.println("Group not found or user already in group");
	}

}
