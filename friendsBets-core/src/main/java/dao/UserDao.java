package dao;

import org.hibernate.Session;

import models.FbsUser;
import utils.HibernateUtils;

public class UserDao extends GenericDao<FbsUser> {

	public UserDao() {
		super(FbsUser.class);
	}

	/**
	 * Find an user with his mail and password (not hashed now)
	 * Launch and close a new session if there is no one running.
	 * @param email
	 * @param password
	 * @return FriendsBetsUser
	 * @throws UserNotFoundException
	 */
	public FbsUser findByEmailAndPassword(String email, String password) {
		FbsUser u = null;
		// use try() close session automatically
		try (Session s = HibernateUtils.getSessionFactory().openSession()) {
			u = findByEmailAndPassword(s, email, password);
		}
		return u;
	}

	/**
	 * Same that findByEmailAndPassword(String email, String password)
	 * @param s
	 * @param email
	 * @param password
	 * @return FriendsBetsUser
	 */
	public FbsUser findByEmailAndPassword(Session s, String email, String password) {

		// Java - 8 JDBC.pdf p.19
		return s.createQuery( // No SELECT !
				"FROM FbsUser f WHERE f.email = :email AND f.password = :password"
				, FbsUser.class)
			.setParameter("email", email)
			.setParameter("password", password)
			.getSingleResult();
	}
}
