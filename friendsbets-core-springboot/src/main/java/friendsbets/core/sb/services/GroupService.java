package friendsbets.core.sb.services;

import java.util.List;

import dao.GroupDao;
import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.exceptions.SqlUniqueContraintException;
import friendsbets.core.sb.models.FbsGroup;
import friendsbets.core.sb.models.FbsUser;

/**
 * TODO Exceptions
 * 
 * All methods what return Groups or update group database
 * 
 * @author gauthier
 *
 */
public class GroupService {
	private GroupDao gDao = new GroupDao();

	public void createGroup(FbsGroup g) throws SqlUniqueContraintException {
		try {
			gDao.save(g);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, g);
		}
	}

	public void deleteGroup(FbsGroup g) throws SqlNotFoundException {
		try {
			gDao.delete(g);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, g);
		}
	}

	public void updateGroup(FbsGroup g) throws SqlNotFoundException {
		try {
			gDao.update(g);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, g);
		}
	}

	public List<FbsGroup> findAllGroups() {
		return gDao.findAll();
	}

	public void addUserToGroup(FbsGroup g, FbsUser u) throws Exception {
		try {
			g.getUserList().add(u);
			updateGroup(g);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, g, u);
		}
	}
	
	public FbsGroup findById(int id) {
		try {
			return gDao.findById(id);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, id);
		}
	}

	/**
	 * not needed cause eager fetchType in user ?????
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException {
//		return gDao.findAllGroupForOneUser(u);
//	}
}
