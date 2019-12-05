package services;

import dao.UserDao;
import models.User;

public class UserService {

	private UserDao uDao = new UserDao();
	
	public void newUser(User u) {
		uDao.save(u);
	}

	public UserDao getuDao() {
		return uDao;
	}
}
