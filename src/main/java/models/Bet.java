package models;

import javax.persistence.*;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class Bet {

	@Id
	private int id;
	@ManyToOne
	private FriendsBetsMatch match;
	@ManyToOne
	private FriendsBetsUser user;
	@ManyToOne
	private FriendsBetsGroup group;
	private int [] score = new int [2];

}
