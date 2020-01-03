package services;

import dao.FriendsBetsUserDao;
import models.FriendsBetsUser;

public class UserService {

	private FriendsBetsUserDao uDao = new FriendsBetsUserDao();
	
	public void newUser(FriendsBetsUser u) throws Exception {
		uDao.save(u);
	}

	public FriendsBetsUserDao getuDao() {
		return uDao;
	}
}
