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
	private long id;
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
	// private int[] score = new int[2]; // tinyblob in database
	private String gain;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BetType betType;

	/**
	 * public ????
	 * 
	 * @author gauthier
	 *
	 */
	public static enum BetType {
		WINNER, DRAW, SCORE
	}

	public FriendsBetsBet() {
	}

	public FriendsBetsBet(FriendsBetsMatch match, FriendsBetsUser betInitialUser, FriendsBetsGroup group,
			Set<FriendsBetsUser> followers, String gain, BetType betType) {
		super();
		this.match = match;
		this.betInitialUser = betInitialUser;
		this.group = group;
		this.followers = followers;
		this.gain = gain;
		this.betType = betType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FriendsBetsMatch getMatch() {
		return match;
	}

	public void setMatch(FriendsBetsMatch match) {
		this.match = match;
	}

	public FriendsBetsUser getBetInitialUser() {
		return betInitialUser;
	}

	public void setBetInitialUser(FriendsBetsUser betInitialUser) {
		this.betInitialUser = betInitialUser;
	}

	public FriendsBetsGroup getGroup() {
		return group;
	}

	public void setGroup(FriendsBetsGroup group) {
		this.group = group;
	}

	public Set<FriendsBetsUser> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<FriendsBetsUser> followers) {
		this.followers = followers;
	}

	public String getGain() {
		return gain;
	}

	public void setGain(String gain) {
		this.gain = gain;
	}

	@Override
	public String toString() {
		return "FriendsBetsBet [id=" + id + ", match=" + match + ", betInitialUser=" + betInitialUser + ", group="
				+ group + ", followers=" + followers + ", gain=" + gain + ", betType=" + betType + "]";
	}

}
