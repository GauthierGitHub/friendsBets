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
public class Group {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private User adminGroup;
	@ManyToMany
	private List<User> userList = new ArrayList<User>();
	@OneToMany(mappedBy = "group")
	private List<Bet> betList = new ArrayList<Bet>();


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
