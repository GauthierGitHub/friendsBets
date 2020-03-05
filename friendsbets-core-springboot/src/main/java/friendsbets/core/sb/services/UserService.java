package friendsbets.core.sb.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.User;
import friendsbets.core.sb.repositories.UserRepository;
import friendsbets.core.sb.utils.HibernateExceptionEncapsulator;

/**
 * All methods what return Users or update user database Exception from dao are
 * caught here and encapsulate into one for code factorization encapsulator util
 * throw traits exception and throw more precise FriendsBetsExceptions TODO
 * others exceptions in service layer
 * 
 * @author gauthier
 *
 */
public class UserService {

	@Autowired
	UserRepository ur;

	// TODO: Validator
//	public static final transient Validator<User> VALIDATOR = new Validator<User>()
//			.addRule("alias", "Alias \"Pierre\" is not allowed !", 
//					me -> !me.getNickname().toLowerCase().equals("pierre"));

	public void save(User u) throws FriendsBetsException {
		ur.save(u);
	}

	public void deleteUser(User u) throws FriendsBetsException {
		ur.delete(u);
	}

	public void updateUser(User u) throws FriendsBetsException {
		ur.save(u);
	}

	public List<User> findAll() {
		return ur.findAll();
	}

	public User findById(int id) {
		return ur.findById(id).orElseThrow();
	}

	public User findByUserMailAndPassword(String email, String password) throws FriendsBetsException {
		return ur.findByEmailAndPassword(email, password);
	}

	public List<Group> findAllGroupForOneUser(User u) throws FriendsBetsException {
		return ur.findAllGroupForOneUser(u);
	}

}
