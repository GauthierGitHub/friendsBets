package friendsbets.core.sb.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
@Table(name="FbsMessage")
public class Message {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Group group;
	@Temporal(TemporalType.TIMESTAMP)
	private Date messageDate;
	@Column(nullable = false)
	private String content; // TODO limit to 255
	
	public Message(){}

	public Message(User user, Group group, Date messageDate, String content) {
		this.user = user;
		this.group = group;
		this.messageDate = messageDate;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
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
