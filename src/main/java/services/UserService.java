package services;

import java.util.List;

import dao.FriendsBetsUserDao;
import exceptions.EmailNicknameUniqueContraintException;
import exceptions.UserNotFoudException;
import models.FriendsBetsUser;

public class UserService {

	private FriendsBetsUserDao uDao = new FriendsBetsUserDao();
	
	/**
	 * Write new User in Database with FriendsBetsUserDao;
	 * catch Exception from DB
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
	
	public FriendsBetsUser findByUserMailAndPassword(String email, String password) throws UserNotFoudException {
		return uDao.findByEmailAndPassword(email, password);
	}
	
	public List<FriendsBetsUser> findAllMembers() {
		return uDao.findAll();
	}
	
	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
