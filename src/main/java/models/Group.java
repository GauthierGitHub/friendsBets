package models;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author barbet
 *
 */
public class Group {
	private static int AUTO_INCREMENT = 0;
	private static int id;
	private List<User> userList = new ArrayList<User>();
	private List<Bet> betList = new ArrayList<Bet>();
	
	public Group() {
		this.id = AUTO_INCREMENT++;
	}
	
}
