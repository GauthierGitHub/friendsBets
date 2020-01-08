package services;

import java.util.List;

import dao.FriendsBetsGroupDao;
import models.FriendsBetsGroup;
import models.FriendsBetsUser;

/**
 * TODO Exceptions
 * 
 * All methods what return Groups
 * or update group database
 * @author gauthier
 *
 */
public class GroupService {
	private FriendsBetsGroupDao gDao = new FriendsBetsGroupDao();

	public void createGroup(FriendsBetsGroup g) throws Exception {
		gDao.save(g);
	}

	public void deleteGroup(FriendsBetsGroup g) throws Exception {
		gDao.delete(g);
	}

	public void updateGroup(FriendsBetsGroup g) throws Exception {
		gDao.update(g);
	}

	public List<FriendsBetsGroup> findAllGroups() {
		return gDao.findAll();
	}

	public void addUserToGroup(FriendsBetsGroup g, FriendsBetsUser u) throws Exception {
		g.getUserList().add(u);
		updateGroup(g);
	}

	/**
	 * not needed cause eager fetchType in user
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException {
//		return gDao.findAllGroupForOneUser(u);
//	}
}
