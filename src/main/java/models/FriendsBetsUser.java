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
public class FriendsBetsUser {

	@Id
	@GeneratedValue // Unique and nullable aren't necessary
	private int id;
	@Column(unique = true, nullable = false)
	private String nickname;
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	@OneToMany(mappedBy = "user")
	private List<Bet> bets;
	@ManyToMany(mappedBy = "userList")
	private List<FriendsBetsGroup> grpList;

	public FriendsBetsUser(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.grpList = new ArrayList<FriendsBetsGroup>();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<FriendsBetsGroup> getGrpList() {
		return grpList;
	}

	public void setGrpList(List<FriendsBetsGroup> grpList) {
		this.grpList = grpList;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FriendsBetsUser [nickname=" + nickname + ", grpList=" + grpList + "]";
	}
}
