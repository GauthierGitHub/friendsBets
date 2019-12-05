package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private static int AUTO_INCREMENT = 0;
	private int id;
	private User adminGroup;
	private List<User> userList = new ArrayList<User>();
	private List<Bet> betList = new ArrayList<Bet>();

	public Group(User u) {
		this.id = AUTO_INCREMENT++;
		this.userList.add(u);
		this.adminGroup = u;
	}

	public int getId() {
		return id;
	}

	public User getAdminGroup() {
		return adminGroup;
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<Bet> getBetList() {
		return betList;
	}

	@Override
	public String toString() {
		String users = "|";
		for (User u : userList) {
			users += u.getNickname() + "|";
		}
		return "Group " + id + "(admin = " + adminGroup.getNickname() 
				+ ")\n  " + users + "\n  betList=" + betList;
	}

}
