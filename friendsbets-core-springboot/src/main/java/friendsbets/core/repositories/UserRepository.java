package friendsbets.core.repositories;

import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	// TODO: my Query
	List<Group> findAllGroupForOneUser(User u);

}
