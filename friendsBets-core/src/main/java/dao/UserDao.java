package dao;

import java.util.List;

import org.hibernate.Session;

import exceptions.FriendsBetsException;
import models.FbsGroup;
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


	/**
	 * not needed cause eager fetchType in user
	 */
	public List<FbsGroup> findAllGroupForOneUser(FbsUser u) throws FriendsBetsException{
		List<FbsGroup> listGroup = null;
		// use try() close session automatically
		try (Session s = HibernateUtils.getSessionFactory().openSession()) {
			listGroup = findAllGroupForOneUser(s, u);
		}catch (Exception e) {
			throw new FriendsBetsException();
		}
		return listGroup;
	}

	/**
	 * JUST KEEP JAVA SYNTHAX WITHOUT JOIN
	 * @param s
	 * @param u
	 * @return
	 */
	public List<FbsGroup> findAllGroupForOneUser(Session s, FbsUser u){
		// Java - 8 JDBC.pdf p.19
		return s.createQuery( // No SELECT ?
				"FROM FbsGroup g"
				+ "INNER JOIN FbsUser u "
				+ "WHERE g IN :u ;"  // ????
				, FbsGroup.class)
				.setParameter("u", u.getId())
				.getResultList();
	}
}
