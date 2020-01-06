package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@JoinColumn(nullable = false) //  @Column(s) not allowed on a @OneToOne property.
	private FriendsBetsUser adminGroup;
	/**
	 * Set is better than arrayList. Jpa will not create both primary key
	 * in the association Table with List ...
	 */
	@ManyToMany
	private Set<FriendsBetsUser> userList = new HashSet<FriendsBetsUser>();
	@OneToMany(mappedBy = "group")
	private List<FriendsBetsBet> betList = new ArrayList<FriendsBetsBet>();

	@Override
	public String toString() {
		String users = "|";
		for (FriendsBetsUser u : userList) {
			users += u.getNickname() + "|";
		}
		return "Group " + id + "(admin = " + adminGroup.getNickname() + ")\n  " + users + "\n  betList=" + betList;
	}

}
