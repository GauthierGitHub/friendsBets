package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @Entity
 * @author Gauthier Barbet 
 * TODO fetchType ? Only User get fetchType ? :
 *         org.hibernate.loader.MultipleBagFetchException: cannot simultaneously
 *         fetch multiple bags error :
 *         org.hibernate.LazyInitializationException: failed to lazily
 *         initialize a collection of role: models.FriendsBetsUser.betsFollowed,
 *         could not initialize proxy - no Session
 *  TODO see serializable id FOR save personnal config
 *  TODO CASCADE.TYPE
 */
@Entity
public class FriendsBetsUser {

	@Id
	@GeneratedValue // Unique and nullable aren't necessary
	private long id;
	@Column(unique = true, nullable = false)
	private String nickname;
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	// org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch
	// multiple bags ?
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST) // TODO cascadeType
	private List<FriendsBetsBet> betsInitialized;
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
	private Set<FriendsBetsBet> betsFollowed;
	@ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
	private List<FriendsBetsGroup> grpList;

	/**
	 * TODO: delete this constructor
	 */
	public FriendsBetsUser() {
		this.nickname = "defaultnickname";
		this.email = "defaultemail";
		this.password = "defaultpassword";
	}

	public FriendsBetsUser(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.grpList = new ArrayList<FriendsBetsGroup>();
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

	public List<FriendsBetsGroup> getGrpList() {
		return grpList;
	}

	public void setGrpList(List<FriendsBetsGroup> grpList) {
		this.grpList = grpList;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FriendsBetsUser [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
				+ ", grpList=" + grpList + "]";
	}

}
