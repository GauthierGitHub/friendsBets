package models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class FriendsBetsMessage {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FriendsBetsUser user;
	@ManyToOne
	@JoinColumn(nullable = false)
	private FriendsBetsGroup group;
	@Temporal(TemporalType.TIMESTAMP)
	private Date messageDate;
	@Column(nullable = false)
	private String content; // TODO limit to 255
	
	public FriendsBetsMessage(){}

	public FriendsBetsMessage(FriendsBetsUser user, FriendsBetsGroup group, Date messageDate, String content) {
		this.user = user;
		this.group = group;
		this.messageDate = messageDate;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FriendsBetsUser getUser() {
		return user;
	}

	public void setUser(FriendsBetsUser user) {
		this.user = user;
	}

	public FriendsBetsGroup getGroup() {
		return group;
	}

	public void setGroup(FriendsBetsGroup group) {
		this.group = group;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
