package services;

import java.util.List;

import dao.FriendsBetsGroupDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
import models.FriendsBetsGroup;
import models.FriendsBetsUser;

/**
 * TODO Exceptions
 * 
 * All methods what return Groups or update group database
 * 
 * @author gauthier
 *
 */
public class GroupService {
	private FriendsBetsGroupDao gDao = new FriendsBetsGroupDao();

	public void createGroup(FriendsBetsGroup g) throws SqlUniqueContraintException {
		try {
			gDao.save(g);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, g);
		}
	}

	public void deleteGroup(FriendsBetsGroup g) throws SqlNotFoundException {
		try {
			gDao.delete(g);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, g);
		}
	}

	public void updateGroup(FriendsBetsGroup g) throws SqlNotFoundException {
		try {
			gDao.delete(g);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, g);
		}
	}

	public List<FriendsBetsGroup> findAllGroups() {
		return gDao.findAll();
	}

	public void addUserToGroup(FriendsBetsGroup g, FriendsBetsUser u) throws Exception {
		try {
			g.getUserList().add(u);
			updateGroup(g);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, g, u);
		}

	}

	/**
	 * not needed cause eager fetchType in user
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException {
//		return gDao.findAllGroupForOneUser(u);
//	}
}
