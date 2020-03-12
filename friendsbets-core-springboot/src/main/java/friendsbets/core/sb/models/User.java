package friendsbets.core.sb.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @Entity
 * @author Gauthier Barbet TODO fetchType ? Only User get fetchType ? :
 *         org.hibernate.loader.MultipleBagFetchException: cannot simultaneously
 *         fetch multiple bags error :
 *         org.hibernate.LazyInitializationException: failed to lazily
 *         initialize a collection of role: models.FriendsBetsUser.betsFollowed,
 *         could not initialize proxy - no Session TODO see serializable id FOR
 *         save personnal config TODO CASCADE.TYPE
 */
//@Table(name="MyUser") // for change name of table
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
//@JsonSubTypes({ // for polymorphisme only ?
//    @JsonSubTypes.Type(value = FbsUser.class, name = "User"),
//    @JsonSubTypes.Type(value = Administrator.class, name = "Administrator")
//})
@Entity
//@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "UserFbs")
public class User {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true, nullable = false)
	private String nickname;
	@Column(nullable = false)
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	private String picturePath;
	// TODO: remove me !
	@JsonIgnore
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST) // TODO cascadeType ?
	private Set<Bet> betsInitialized;
	@JsonIgnore
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
	private Set<Bet> betsFollowed = new TreeSet<Bet>();
	@JsonIgnore
	@ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
	private Set<Group> grpList = new HashSet<Group>();
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> friends = new HashSet<User>();
	protected String token;
	protected LocalDateTime tokenLastUsed;

	/**
	 * TODO: delete this constructor
	 */
	public User() {
		this.nickname = "defaultnickname";
		this.email = "defaultemail";
		this.password = "defaultpassword";
	}

	public User(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
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

	public Set<Group> getGrpList() {
		return grpList;
	}

	public void setGrpList(Set<Group> grpList) {
		this.grpList = grpList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Set<Bet> getBetsInitialized() {
		return betsInitialized;
	}

	public void setBetsInitialized(Set<Bet> betsInitialized) {
		this.betsInitialized = betsInitialized;
	}

	@XmlTransient
	@JsonIgnore
	public Set<Bet> getBetsFollowed() {
		return betsFollowed;
	}

	public void setBetsFollowed(Set<Bet> betsFollowed) {
		this.betsFollowed = betsFollowed;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenLastUsed() {
		return tokenLastUsed;
	}

	public void setTokenLastUsed(LocalDateTime tokenLastUsed) {
		this.tokenLastUsed = tokenLastUsed;
	}

//	@Override
//	public String toString() {
//		return "FriendsBetsUser [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
//				+ ", grpList=" + grpList + "]";
//	}

}
