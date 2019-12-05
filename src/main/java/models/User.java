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

	private String nickname;
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", grpList=" + grpList + "]";
	}
}
