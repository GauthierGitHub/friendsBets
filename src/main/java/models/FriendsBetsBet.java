package models;

import java.util.Set;

import javax.persistence.*;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FriendsBetsBet {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FriendsBetsMatch match;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FriendsBetsUser betInitialUser;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FriendsBetsGroup group;
	@ManyToMany
	private Set<FriendsBetsUser> followers;
	// TODO bet selection WINNER DRAW SCORE
	//private int[] score = new int[2]; // tinyblob in database
	private String gain;
	@Column(nullable = false)
	private BetType betType;
	
	private enum BetType {
		WINNER,
		DRAW,
		SCORE
	}

}
