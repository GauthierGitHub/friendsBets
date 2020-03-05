package friendsbets.core.sb.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
@Table(name="FbsGroup")
public class Group {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = true)
	private String name;
	@ManyToOne
//	@JoinColumn(nullable = false) // @Column(s) not allowed on a @OneToOne property.
	private User adminGroup;
	/**
	 * Set is better than arrayList. Jpa will not create both primary key in the
	 * association Table with List ... Can be resolved buy @EmbeddedId ?
	 * TODO: Better way to fetch type ? here user calls groups and not inverse
	 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY) 
	private Set<User> userList = new HashSet<User>();
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Bet> betList = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Message> groupMessages;
	
	public Group() {}
	
	public Group(User u) {
		this.adminGroup = u;
		userList.add(adminGroup);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public User getAdminGroup() {
		return adminGroup;
	}
	public void setAdminGroup(User adminGroup) {
		this.adminGroup = adminGroup;
	}

	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	public List<Bet> getBetList() {
		return betList;
	}
	public void setBetList(List<Bet> betList) {
		this.betList = betList;
	}

	public List<Message> getGroupMessages() {
		return groupMessages;
	}
	public void setGroupMessages(List<Message> groupMessages) {
		this.groupMessages = groupMessages;
	}

//	@Override
//	public String toString() {
//		String users = "|";
//		for (FbsUser u : userList) {
//			users += u.getNickname() + "|";
//		}
//		return "Group " + id + "(admin = " + adminGroup.getNickname() + ")\n  " + users;
//	}

}
