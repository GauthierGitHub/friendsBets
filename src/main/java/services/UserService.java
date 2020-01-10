package services;

import java.util.List;

import dao.FriendsBetsUserDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
import models.FriendsBetsUser;

/**
 * All methods what return Users
 * or update user database
 * @author gauthier
 *
 */
public class UserService {

	private FriendsBetsUserDao uDao = new FriendsBetsUserDao();

	/**
	 * Write new User in Database with FriendsBetsUserDao; catch Exception from DB
	 * 
	 * @param u
	 * @throws UserUniqueContraintException
	 */
	public void newUser(FriendsBetsUser u) throws SqlUniqueContraintException {
		try {
			uDao.save(u);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, u);
		}
	}

	public void deleteMember(FriendsBetsUser u) throws SqlNotFoundException {
		try {
			uDao.delete(u);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, u);
		}
	}

	public void updateMember(FriendsBetsUser u) throws SqlNotFoundException {
		try {
			uDao.update(u);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, u);
		}
	}

	public List<FriendsBetsUser> findAllMembers() {
		// TODO null pointer exception ? for all services ?
		return uDao.findAll();
	}

	public FriendsBetsUser findByUserMailAndPassword(String email, String password) throws SqlNotFoundException {
		try {
			return uDao.findByEmailAndPassword(email, password);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, email);
		}
	}

	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
