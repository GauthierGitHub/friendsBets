package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.MyException;
import models.Group;
import models.User;

public class GroupDao extends GenericDao<Group>{

	public void addUserInGroup(Group g, List<User> lu/*, User admin*/) throws MyException {
		// TODO only admin do
		// TODO check if user yet in group
		// TODO excetpion if group or user not found
		// TODO if admin leave the group
		
//		// find the group in database, return a list
//		List<Group> gInDb = findBy(x->x.getId()==g.getId());
//		// take the first on the list
//		gInDb.get(0).getUserList().addAll(lu);
		
		try {
			// check if one user in list is yet in group
			Iterator<User> it = lu.iterator();
			while(it.hasNext()) {
				if(lu.contains(it.next()))
					System.out.println();;
			}

			// find the group in database
			Group gInDb = database.get(g.getId());
			// write in db
			gInDb.getUserList().addAll(lu);
		} catch (Exception e) {
			// TODO do all exception
			throw new MyException("addUserInGroup",e);
		} 
	}
}
