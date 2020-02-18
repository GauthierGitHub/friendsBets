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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FbsGroup {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = true)
	private String name;
	@ManyToOne
//	@JoinColumn(nullable = false) // @Column(s) not allowed on a @OneToOne property.
	private FbsUser adminGroup;
	/**
	 * Set is better than arrayList. Jpa will not create both primary key in the
	 * association Table with List ... Can be resolved buy @EmbeddedId ?
	 * TODO: Better way to fetch type ? here user calls groups and not inverse
	 */
	@ManyToMany(fetch = FetchType.LAZY) 
	private Set<FbsUser> userList = new HashSet<FbsUser>();
	@OneToMany(mappedBy = "group")
	private List<FbsBet> betList = new ArrayList<>();
	@OneToMany(mappedBy = "group")
	private List<FbsMessage> groupMessages;
	
	public FbsGroup() {}
	
	public FbsGroup(FbsUser u) {
		FbsGrAdmin adminGroup = new FbsGrAdmin(this, u);
		this.adminGroup = adminGroup;
		userList.add(adminGroup);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FbsUser getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(FbsGrAdmin adminGroup) {
		this.adminGroup = adminGroup;
	}

	public Set<FbsUser> getUserList() {
		return userList;
	}

	public void setUserList(Set<FbsUser> userList) {
		this.userList = userList;
	}

	public List<FbsBet> getBetList() {
		return betList;
	}

	public void setBetList(List<FbsBet> betList) {
		this.betList = betList;
	}

	public List<FbsMessage> getGroupMessages() {
		return groupMessages;
	}

	public void setGroupMessages(List<FbsMessage> groupMessages) {
		this.groupMessages = groupMessages;
	}

	@Override
	public String toString() {
		String users = "|";
		for (FbsUser u : userList) {
			users += u.getNickname() + "|";
		}
		return "Group " + id + "(admin = " + adminGroup.getNickname() + ")\n  " + users;
	}

}
