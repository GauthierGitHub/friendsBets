package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FbsBet {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FbsMatch match;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FbsUser betInitialUser;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FbsGroup group;
	@ManyToMany
	private Set<FbsUser> followers;
	// TODO bet selection WINNER DRAW SCORE
	// private int[] score = new int[2]; // tinyblob in database
	private String gain;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING) // TODO String or int ?
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

	public FbsBet() {
	}

	public FbsBet(FbsMatch match, FbsUser betInitialUser, FbsGroup group,
			Set<FbsUser> followers, String gain, BetType betType) {
		super();
		this.match = match;
		this.betInitialUser = betInitialUser;
		this.group = group;
		this.followers = followers;
		this.gain = gain;
		this.betType = betType;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FbsMatch getMatch() {
		return match;
	}

	public void setMatch(FbsMatch match) {
		this.match = match;
	}

	public FbsUser getBetInitialUser() {
		return betInitialUser;
	}

	public void setBetInitialUser(FbsUser betInitialUser) {
		this.betInitialUser = betInitialUser;
	}

	public FbsGroup getGroup() {
		return group;
	}

	public void setGroup(FbsGroup group) {
		this.group = group;
	}

	public Set<FbsUser> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<FbsUser> followers) {
		this.followers = followers;
	}

	public String getGain() {
		return gain;
	}

	public void setGain(String gain) {
		this.gain = gain;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

//	@Override JAMAIS DE TOUT TOSTRING AVEC HIBERNATE
//	public String toString() {
//		return "FriendsBetsBet [id=" + id + ", match=" + match + ", betInitialUser=" + betInitialUser + ", group="
//				+ group + ", followers=" + followers + ", gain=" + gain + ", betType=" + betType + "]";
//	}

}
