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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
// id generator for repeated objects
@JsonIdentityInfo(scope = Message.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "MessageFbs")
public class Message {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User author;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIdentityReference(alwaysAsId = true) // only id in json
	private Group group;
	@Temporal(TemporalType.TIMESTAMP) // TODO: verify beetwen angular date or database timestamp
	private Date date;
	@Column(nullable = false)
	private String content; // TODO limit to 255

	public Message() {
	}

	public Message(User user, Group group, Date messageDate, String content) {
		this.author = user;
		this.group = group;
		this.date = messageDate;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User user) {
		this.author = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
