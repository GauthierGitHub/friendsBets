package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.exceptions.SqlUniqueContraintException;
import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.User;
import friendsbets.core.sb.repositories.GroupRepository;
import friendsbets.core.sb.repositories.UserRepository;

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
	@Autowired
	UserRepository ur;

	public void save(Group g) {
		gr.save(g);
		g.getUserList().stream().forEach(user-> {
			user.getGrpList().add(g);
			ur.save(user);
		});
	}

	public void delete(Group g) {
		gr.delete(g);
	}

	public void update(Group g) {
		gr.save(g);
	}

	public List<Group> findAll() {
		return gr.findAll();
	}

	public void addUserToGroup(Group g, User u) {
		g.getUserList().add(u);
		update(g);
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
