package friendsbets.core.sb.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import friendsbets.core.sb.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	/**
	 * @Query(
		  value = "SELECT * FROM USERS u WHERE u.status = 1", 
		  nativeQuery = true)
		Collection<User> findAllActiveUsersNative();
		@Query("from User u where u = %?1%")
	 * @param u
	 * @return
	 */
	// TODO: my Query ?
//	@Query("FROM Group g WHERE g.User = ?1")
//	List<Group> findAllGroupForOneUser(User u);

	// TODO: my Query ?
	@Query("from User u where u.nickname like %?1% or u.email like %?1%")
	Set<User> findByNicknameOrEmailLike(String pattern);

	@Query("FROM User u where u = ?1")
	Set<User> findFriends(User u);

}
