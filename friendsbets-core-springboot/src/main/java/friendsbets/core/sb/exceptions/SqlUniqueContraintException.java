package friendsbets.core.sb.exceptions;

import friendsbets.core.sb.models.Bet;
import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.Match;
import friendsbets.core.sb.models.User;

public class SqlUniqueContraintException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SqlUniqueContraintException(Exception e, Bet b) {
		System.out.println("Bet already done !");
	}

	public SqlUniqueContraintException(Exception e, User u) {
		System.out.println("User mail already register or nickname yet reserved");
	}

	public SqlUniqueContraintException(Exception e, Match m) {
		System.out.println("Match already writte in database");
	}

	public SqlUniqueContraintException(Exception e, Group g) {
		e.printStackTrace();
		System.out.println("Same group already done !");
	}

	public SqlUniqueContraintException(Exception e, Group g, User u) {
		e.printStackTrace();
		System.out.println("Group not found or user already in group");
	}

}
