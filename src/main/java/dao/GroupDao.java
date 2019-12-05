package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.MyException;
import models.Group;
import models.User;

public class GroupDao extends GenericDao<Group>{

	public void saveUserInGroup(Group g, List<User> lu) throws MyException {
		try {
			// find the group in database and write users into
			database.get(g.getId()).getUserList().addAll(lu);
		} catch (Exception e) {
			// TODO do all database exception
			throw new MyException("GroupDao.save",e);
		} 
	}

	public void deletUserInGroup(Group g, List<User> lu) throws MyException {
		// TODO Auto-generated method stub
		try {
			// find the group in database and write users into
			database.get(g.getId()).getUserList().removeAll(lu);
		} catch (Exception e) {
			// TODO do all database exception
			throw new MyException("GroupDao.update",e);
		} 
	}
}
