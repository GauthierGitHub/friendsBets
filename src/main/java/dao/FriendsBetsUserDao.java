package dao;

import org.hibernate.Session;

import exceptions.UserNotFoudException;
import models.FriendsBetsUser;
import utils.HibernateUtils;

public class FriendsBetsUserDao extends GenericDao<FriendsBetsUser> {

	public FriendsBetsUserDao() {
		super(FriendsBetsUser.class);
	}

	/**
	 * Find an user with his mail and password (not hash now)
	 * Can be Use for login ?
	 * Launch and close a new session if there is no one.
	 * @param email
	 * @param password
	 * @return FriendsBetsUser
	 * @throws UserNotFoudException
	 */
	public FriendsBetsUser findByEmailAndPassword(String email, String password) throws UserNotFoudException {
		FriendsBetsUser fbu = null;
		// use try() close session automatically
		try (Session s = HibernateUtils.getSessionfactory().openSession()) {
			fbu = findByEmailAndPassword(s, email, password);
		}catch (Exception e) {
			throw new UserNotFoudException();
		}
		return fbu;
	}

	/**
	 * Same that findByEmailAndPassword(String email, String password)
	 * @param s
	 * @param email
	 * @param password
	 * @return FriendsBetsUser
	 */
	public FriendsBetsUser findByEmailAndPassword(Session s, String email, String password) {

		// Java - 8 JDBC.pdf p.19
		return s.createQuery( // No SELECT !
				"FROM FriendsBetsUser f WHERE f.email = :email AND f.password = :password"
				, FriendsBetsUser.class)
			.setParameter("email", email)
			.setParameter("password", password)
			.getSingleResult();
	}
}
