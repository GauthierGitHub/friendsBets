package friendsbets.core.sb.exceptions;

import friendsbets.core.sb.models.FbsBet;
import friendsbets.core.sb.models.FbsGroup;
import friendsbets.core.sb.models.FbsMatch;
import friendsbets.core.sb.models.FbsUser;

public class SqlUniqueContraintException extends Exception {

	public SqlUniqueContraintException(Exception e, FbsBet b) {
		System.out.println("Bet already done !");
	}

	public SqlUniqueContraintException(Exception e, FbsUser u) {
		System.out.println("User mail already register or nickname yet reserved");
	}

	public SqlUniqueContraintException(Exception e, FbsMatch m) {
		System.out.println("Match already writte in database");
	}

	public SqlUniqueContraintException(Exception e, FbsGroup g) {
		e.printStackTrace();
		System.out.println("Same group already done !");
	}

	public SqlUniqueContraintException(Exception e, FbsGroup g, FbsUser u) {
		e.printStackTrace();
		System.out.println("Group not found or user already in group");
	}

}
