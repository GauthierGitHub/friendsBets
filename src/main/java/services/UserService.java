package services;

import java.util.List;

import dao.FriendsBetsGroupDao;
import dao.FriendsBetsUserDao;
import exceptions.UserUniqueContraintException;
import exceptions.UserNotFoundException;
import models.FriendsBetsUser;

/**
 * All methods what return Users
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
	public void newUser(FriendsBetsUser u) throws UserUniqueContraintException {
		try {
			uDao.save(u);
		} catch (Exception e) {
			throw new UserUniqueContraintException();
		}
	}

	public void deleteMember(FriendsBetsUser u) throws UserNotFoundException {
		try {
			uDao.delete(u);
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
	}

	public void updateMember(FriendsBetsUser u) throws UserNotFoundException {
		try {
			uDao.update(u);
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
	}

	public List<FriendsBetsUser> findAllMembers() {
		return uDao.findAll();
	}

	public FriendsBetsUser findByUserMailAndPassword(String email, String password) throws UserNotFoundException {
		return uDao.findByEmailAndPassword(email, password);
	}

	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
