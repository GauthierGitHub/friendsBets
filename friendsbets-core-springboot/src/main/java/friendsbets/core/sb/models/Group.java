package friendsbets.core.sb.models;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
@Table(name="GroupFbs")
public class Group {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = true)
	private String name;
//	@ManyToOne
	// TODO: DELETE ME ! first user is Admin ?
//	@JoinColumn(nullable = false) // @Column(s) not allowed on a @OneToOne property.
//	private User adminGroup;
	/**
	 * Set is better than arrayList. Jpa will not create both primary key in the
	 * association Table with List ... Can be resolved by @EmbeddedId ?
	 * TODO: Better way to fetch type ? here user calls groups and not inverse
	 */
//	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY) 
	private Set<User> userList = new LinkedHashSet<User>();
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private Set<Bet> betList = new TreeSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Message> groupMessages;
	private String picturePath;
	
	public Group() {}
	
//	public Group(User u) {
//		this.adminGroup = u;
//		userList.add(adminGroup);
//	}

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

//	public User getAdminGroup() {
//		return adminGroup;
//	}
//	public void setAdminGroup(User adminGroup) {
//		this.adminGroup = adminGroup;
//	}

	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	public Set<Bet> getBetList() {
		return betList;
	}
	public void setBetList(Set<Bet> betList) {
		this.betList = betList;
	}

	public List<Message> getGroupMessages() {
		return groupMessages;
	}
	public void setGroupMessages(List<Message> groupMessages) {
		this.groupMessages = groupMessages;
	}

	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
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
