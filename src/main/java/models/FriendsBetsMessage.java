package models;


import java.util.Date;

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
	private String content;
	
	public FriendsBetsMessage(){}
}
