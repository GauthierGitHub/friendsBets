package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
public class Bet {

	@OneToOne
	private Match match;
	@ManyToOne
	private User user;
	@ManyToOne
	private Group group;
	private int [] score = new int [2];

}
