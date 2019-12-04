package models;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author barbet
 *
 */
public class User {
	private static int AUTO_INCREMENT = 0;
	private static int id;
	private String nickname;
	private List<Group> grpList;

	public User(String nickname) {
		this.id = AUTO_INCREMENT++;
		this.nickname = nickname;
		this.grpList = new ArrayList<Group>();
	}

	public Group createGroup() {
//		Group g = new Group();
//		return g.add(this);
		return new Group();
	}
	
	public String getNickname() {
		return nickname;
	}

	
}
