package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private long id;
	@Column(nullable = true)
	private String name;
	@OneToOne
	@JoinColumn(nullable = false) // @Column(s) not allowed on a @OneToOne property.
	private FriendsBetsUser adminGroup;
	/**
	 * Set is better than arrayList. Jpa will not create both primary key in the
	 * association Table with List ... Can be resolved buy @EmbeddedId ?
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<FriendsBetsUser> userList = new HashSet<FriendsBetsUser>();
	@OneToMany(mappedBy = "group")
	private List<FriendsBetsBet> betList = new ArrayList<FriendsBetsBet>();
	@OneToMany(mappedBy = "group")
	private List<FriendsBetsMessage> groupMessages;
	
	public FriendsBetsGroup() {}
	
	public FriendsBetsGroup(FriendsBetsUser adminGroup) {
		this.adminGroup = adminGroup;
		userList.add(adminGroup);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FriendsBetsUser getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(FriendsBetsUser adminGroup) {
		this.adminGroup = adminGroup;
	}

	public Set<FriendsBetsUser> getUserList() {
		return userList;
	}

	public void setUserList(Set<FriendsBetsUser> userList) {
		this.userList = userList;
	}

	public List<FriendsBetsBet> getBetList() {
		return betList;
	}

	public void setBetList(List<FriendsBetsBet> betList) {
		this.betList = betList;
	}

	@Override
	public String toString() {
		String users = "|";
		for (FriendsBetsUser u : userList) {
			users += u.getNickname() + "|";
		}
		return "Group " + id + "(admin = " + adminGroup.getNickname() + ")\n  " + users;
	}

}
