package friendsbets.core.sb.models;

import java.time.LocalDateTime;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
//@Table(name="MyUser") // for change name of table
@XmlRootElement
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
//@JsonSubTypes({ // for polymorphisme only ?
//    @JsonSubTypes.Type(value = FbsUser.class, name = "User"),
//    @JsonSubTypes.Type(value = Administrator.class, name = "Administrator")
//})
public class FbsUser {

	@Id
	@GeneratedValue // Unique and nullable aren't necessary
	private int id;
	@Column(unique = true, nullable = false)
	private String nickname;
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	// org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch
	// multiple bags ?
	private String picturePath;
	@JsonIgnore
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST) // TODO cascadeType ?
	private List<FbsBet> betsInitialized;
	@JsonIgnore
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY) // TODO eager ? !!!!!!!!!!!!!!!!!!!
	private Set<FbsBet> betsFollowed;
	@ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER) // TODO eager ? !!!!!!!!!!!!!!!!!!!
	private List<FbsGroup> grpList;

	protected String token;
	protected LocalDateTime tokenLastUsed;

	/**
	 * TODO: delete this constructor
	 */
	public FbsUser() {
		this.nickname = "defaultnickname";
		this.email = "defaultemail";
		this.password = "defaultpassword";
	}

	public FbsUser(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.grpList = new ArrayList<FbsGroup>();
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

	public List<FbsGroup> getGrpList() {
		return grpList;
	}
	public void setGrpList(List<FbsGroup> grpList) {
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

	public List<FbsBet> getBetsInitialized() {
		return betsInitialized;
	}
	public void setBetsInitialized(List<FbsBet> betsInitialized) {
		this.betsInitialized = betsInitialized;
	}
	
	@XmlTransient
	@JsonIgnore
	public Set<FbsBet> getBetsFollowed() {
		return betsFollowed;
	}
	public void setBetsFollowed(Set<FbsBet> betsFollowed) {
		this.betsFollowed = betsFollowed;
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
