package services;

import java.util.List;

import dao.FriendsBetsGroupDao;
import dao.FriendsBetsUserDao;
import exceptions.EmailNicknameUniqueContraintException;
import exceptions.UserNotFoudException;
import models.FriendsBetsGroup;
import models.FriendsBetsUser;

public class UserService {

	private FriendsBetsUserDao uDao = new FriendsBetsUserDao();
	private FriendsBetsGroupDao gDao = new FriendsBetsGroupDao();

	/**
	 * Write new User in Database with FriendsBetsUserDao; catch Exception from DB
	 * 
	 * @param u
	 * @throws EmailNicknameUniqueContraintException
	 */
	public void newUser(FriendsBetsUser u) throws EmailNicknameUniqueContraintException {
		try {
			uDao.save(u);
		} catch (Exception e) {
			throw new EmailNicknameUniqueContraintException();
		}
	}

	public void deleteMember(FriendsBetsUser u) throws Exception {
		uDao.delete(u);
	}

	public void updateMember(FriendsBetsUser u) throws Exception {
		uDao.update(u);
	}

	public List<FriendsBetsUser> findAllMembers() {
		return uDao.findAll();
	}

	public FriendsBetsUser findByUserMailAndPassword(String email, String password) throws UserNotFoudException {
		return uDao.findByEmailAndPassword(email, password);
	}

	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
