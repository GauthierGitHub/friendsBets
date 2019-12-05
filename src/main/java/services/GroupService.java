package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.GroupDao;
import exceptions.MyException;
import models.Group;
import models.User;

public class GroupService {
	
	private GroupDao gDao = new GroupDao();
	
	public void createGroup(User u) {
		// new group with u as admin
		Group g = new Group(u);
		// Write group in database
		gDao.save(g);
	}

	public void addUserInGroup(Group g, List<User> lu) throws MyException {
		// TODO only admin do in presentation view ?
		// TODO exception if group or user not found
		// TODO if admin leave the group
		// TODO associative tables UserInGroup ?
		
		try {
			// find the group in database
			Group gInDb = gDao.findAll().get(g.getId());
			
			// check if one user in list is yet in group, if yes delete it from lu
			// control in GUI ?
			for(User u : gInDb.getUserList()) {
				if(gInDb.getUserList().contains(u))
					lu.remove(u);
			}
			
			// write in db
			gDao.saveUserInGroup(g, lu);
		} catch (Exception e) {
			// TODO do all exception
			throw new MyException("addUserInGroup",e);
		} 
	}
	
	public void deleteUserInGroup(Group g, List<User> lu, User newAdmin) throws MyException {
		
		try {
			// find the group in database
			Group gInDb = gDao.findAll().get(g.getId());
			// TODO check users in list is yet in group in GUI ?
			gInDb.getUserList().removeAll(lu);
			gInDb.setAdminGroup(newAdmin);

			// write in db
			gDao.deletUserInGroup(g, lu);
		} catch (Exception e) {
			// TODO do all exception
			throw new MyException("addUserInGroup",e);
		} 
	}
	
	public GroupDao getgDao() {
		return gDao;
	}
}
