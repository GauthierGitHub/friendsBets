package exceptions;

import org.hibernate.HibernateException;

public class JuniorDeveloperException extends FriendsBetsException {

	public JuniorDeveloperException(HibernateException ex) {
		System.out.println("Junior Developper exception");
		}

}
