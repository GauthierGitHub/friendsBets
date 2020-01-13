package services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

import dao.FriendsBetsUserDao;
import exceptions.FriendsBetsException;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
import models.FriendsBetsUser;
import utils.HibernateExceptionEncapsulator;

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
	private transient FriendsBetsUserDao uDao = new FriendsBetsUserDao();
	

	/**
	 * Write new User in Database with FriendsBetsUserDao; catch Exception from DB
	 * 
	 * @param u
	 * @throws FriendsBetsException 
	 * @throws UserUniqueContraintException
	 */
	public void newUser(FriendsBetsUser u) throws FriendsBetsException {
		try {
			uDao.save(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public void deleteMember(FriendsBetsUser u) throws FriendsBetsException {
		try {
			uDao.delete(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public void updateMember(FriendsBetsUser u) throws FriendsBetsException {
		try {
			uDao.update(u);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public List<FriendsBetsUser> findAllMembers() {
		// TODO null pointer exception ? for all services ?
		return uDao.findAll();
	}

	public FriendsBetsUser findByUserMailAndPassword(String email, String password) throws FriendsBetsException {
		try {
			return uDao.findByEmailAndPassword(email, password);
		} catch (HibernateException ex) {
			throw HibernateExceptionEncapsulator.encapsulate(ex);
		}
	}

	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
