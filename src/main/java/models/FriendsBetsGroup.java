package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FriendsBetsGroup {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@Column(unique = true, nullable = false)
	private FriendsBetsUser adminGroup;
	@ManyToMany(mappedBy = "grpList")
	private List<FriendsBetsUser> userList = new ArrayList<FriendsBetsUser>();
	@OneToMany(mappedBy = "group")
	private List<Bet> betList = new ArrayList<Bet>();

	@Override
	public String toString() {
		String users = "|";
		for (FriendsBetsUser u : userList) {
			users += u.getNickname() + "|";
		}
		return "Group " + id + "(admin = " + adminGroup.getNickname() + ")\n  " + users + "\n  betList=" + betList;
	}

}
