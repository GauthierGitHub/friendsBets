package friendsbets.core.sb.services;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.commons.lang3.RandomStringUtils;


import dao.UserDao;
import friendsbets.core.sb.exceptions.AuthenticationException;
import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.models.FbsGroup;
import friendsbets.core.sb.models.FbsUser;
import friendsbets.core.sb.utils.HibernateExceptionEncapsulator;
import friendsbets.core.sb.utils.HibernateUtils;
import friendsbets.core.sb.utils.Validator;

/**
 * All methods what return Users or update user database
 * Exception from dao are caught here and encapsulate into one for code factorization
 * encapsulator util throw traits exception and throw more precise FriendsBetsExceptions
 * TODO others exceptions in service layer
 * @author gauthier
 *
 */
public class UserService  implements Serializable {


	/**
	 * Used for serialization
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * transient used for being ignored by serialization.
	 */
	private transient UserDao uDao = new UserDao();
	
	public static final transient Validator<FbsUser> VALIDATOR = new Validator<FbsUser>()
			.addRule("alias", "Alias \"Pierre\" is not allowed !", 
					me -> !me.getNickname().toLowerCase().equals("pierre"));
		// TODO: Add rules and copy them in Validator.js
	/*
			.addRule("alias", "Alias must be at least 8 characters long", 
					me -> me.getNickname().length() >= 8)
			.addRule("email", "invalid email format", 
					me -> me.getEmail().contains("@"))
			.addRule("password", "Password must be at least 8 characters long", 
					me -> me.getPassword().length() >= 8);
	*/
	
	public UserService() {
		super();
		uDao = new UserDao();
	}

	public UserService(UserDao uDao) {
		super();
		this.uDao = uDao;
	}

	/**
	 * Write new User in Database with FriendsBetsUserDao; catch Exception from DB
	 * 
	 * @param u
	 * @throws FriendsBetsException 
	 * @throws UserUniqueContraintException
	 */
	public void newUser(FbsUser u) throws FriendsBetsException{
		try {
			uDao.save(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public void deleteUser(FbsUser u) throws FriendsBetsException {
		try {
			uDao.delete(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public void updateUser(FbsUser u) throws FriendsBetsException {
		try {
			uDao.update(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public List<FbsUser> findAll() {
		// TODO null pointer exception ? for all services ?
		return uDao.findAll();
	}

	public FbsUser findById(int id) {
		return uDao.findById(id);
	}
	
	public FbsUser findByUserMailAndPassword(String email, String password) throws FriendsBetsException {
		try {
			return uDao.findByEmailAndPassword(email, password);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}
	
	public List<FbsGroup> findAllGroupForOneUser(FbsUser u) throws FriendsBetsException {
		try {
			return uDao.findAllGroupForOneUser(u);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw HibernateExceptionEncapsulator.encapsulate(e);
		}
	}

	public FbsUser login(String email, String password) throws FriendsBetsException, AuthenticationException {
		Transaction t = null;
		try (Session s = HibernateUtils.getSessionFactory().openSession()) {
			t = s.beginTransaction();
			FbsUser m = uDao.findByEmailAndPassword(s, email, password);
			if (m == null)
				throw new AuthenticationException("invalid email or password");
			m.setToken(RandomStringUtils.randomAlphanumeric(30));
			m.setTokenLastUsed(LocalDateTime.now());
			t.commit();
			return m;
		} catch (NoResultException ex) {
			if (t != null) t.rollback();
			throw new AuthenticationException("invalid email or password", ex);
		} catch (HibernateException ex) {
			if (t != null) t.rollback();
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}
	

	public FbsUser findByToken(String token, TemporalAmount validDuration, boolean update) throws FriendsBetsException, AuthenticationException {
		try {
			FbsUser m = uDao.findByToken(token);
			if (m == null)
				throw new AuthenticationException("invalid token");
			if (!m.getTokenLastUsed().isAfter(LocalDateTime.now().minus(validDuration)))
				throw new AuthenticationException("expired token");
			return m;
		} catch (NoResultException ex) {
			throw new AuthenticationException("invalid token", ex);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}
}
