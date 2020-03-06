package friendsbets.core.sb.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.sb.models.User;
import friendsbets.core.sb.repositories.UserRepository;

/**
 * All methods what return Users or update user database Exception from dao are
 * caught here and encapsulate into one for code factorization encapsulator util
 * throw traits exception and throw more precise FriendsBetsExceptions TODO
 * others exceptions in service layer
 * 
 * @author gauthier
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository ur;

	// TODO: Validator
//	public static final transient Validator<User> VALIDATOR = new Validator<User>()
//			.addRule("alias", "Alias \"Pierre\" is not allowed !", 
//					me -> !me.getNickname().toLowerCase().equals("pierre"));

	public void save(User u) {
		ur.save(u);
	}

	public void delete(User u) {
		ur.delete(u);
	}

	public void update(User u) {
		ur.save(u);
	}

	public List<User> findAll() {
		return ur.findAll();
	}

	public User findById(int id) {
		return ur.findById(id).orElseThrow();
	}

	public User findByUserMailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}
	
	public Set<User> findFriends(User u) {
		return ur.findFriends(u);
	}
	
	public void addFriends(User u1, User u2) {
		u1.getFriends().add(u2);
		u2.getFriends().add(u1);
	}

	public List<User> findAllOthers(int id) {
		// TODO: see difference; List or Set ?
//		Set<User> result = new HashSet<>();
//		ur.findAll().stream().distinct().filter(x -> x != u).forEach(y -> result.add(y));;
		List<User> result = ur.findAll();
		result.remove(id);
		return result;
	}
//	public List<Group> findAllGroupForOneUser(User u) {
//		return ur.findAllGroupForOneUser(u);
//	}

	public Set<User> findByNicknameOrEmailLike(String pattern) {
		return ur.findByNicknameOrEmailLike(pattern);
	}

}
