package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.exceptions.SqlUniqueContraintException;
import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.User;
import friendsbets.core.sb.repositories.GroupRepository;

/**
 * TODO Exceptions
 * 
 * All methods what return Groups or update group database
 * 
 * @author gauthier
 *
 */
@Service
public class GroupService {

	@Autowired
	GroupRepository gr;

	public void createGroup(Group g) throws SqlUniqueContraintException {
		gr.save(g);
	}

	public void deleteGroup(Group g) throws SqlNotFoundException {
		gr.delete(g);
	}

	public void updateGroup(Group g) throws SqlNotFoundException {
		gr.save(g);
	}

	public List<Group> findAllGroups() {
		return gr.findAll();
	}

	public void addUserToGroup(Group g, User u) throws Exception {
		g.getUserList().add(u);
		updateGroup(g);
	}

	public Group findById(int id) {
		return gr.findById(id).orElseThrow();
	}

	/**
	 * not needed cause eager fetchType in user ?????
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException {
//		return gr.findAllGroupForOneUser(u);
//	}
}
