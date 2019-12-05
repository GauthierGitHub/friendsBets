package models;

import java.util.ArrayList;
import java.util.List;
/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
public class User {

	private static int AUTO_INCREMENT = 0;
	private static int id;
	private String nickname;
	private String password;
	private String email;
	private List<Group> grpList;

	public User(String nickname, String email, String password) {
		this.id = AUTO_INCREMENT++;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.grpList = new ArrayList<Group>();
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

	public List<Group> getGrpList() {
		return grpList;
	}

	public void setGrpList(List<Group> grpList) {
		this.grpList = grpList;
	}

	public static int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", grpList=" + grpList + "]";
	}
}
