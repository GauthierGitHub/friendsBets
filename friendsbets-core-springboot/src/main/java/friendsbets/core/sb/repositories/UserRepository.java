package friendsbets.core.sb.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import friendsbets.core.sb.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	@Query("from User u where u.nickname like %?1% or u.email like %?1%")
	Set<User> findByNicknameOrEmailLike(String pattern);

	/**
	 * native mysql
	 * Return all user who are not the connected user and his friends
	 * TODO: find a way without NOT IN
	 * //			"SELECT * FROM UserFbs LEFT JOIN UserFbs_friends ON UserFbs.id = UserFbs_friends.User_id WHERE UserFbs_friends.User_id != ?1 AND id != friends_id"
	 * @param id
	 * @return Set<User>  
	 */
	@Query(value="SELECT * FROM UserFbs "
				+ "WHERE id != ?1 AND id NOT IN ("
						+ "SELECT friends_id "
						+ "FROM UserFbs_friends "
						+ "WHERE UserFbs_friends.User_id = ?1)"
			, nativeQuery = true)
	Set<User> findAllOthers(int id); // or User u ?

	/**
	 * native mysql 
	 * Return all friends for one user
	 *		//	@Query("FROM User.friends u where u = ?1")
	 *		//	Set<User> findFriends(User u);
	 * @param id
	 * @return
	 */
	@Query(value=
			"SELECT * FROM UserFbs "
			+ "RIGHT JOIN UserFbs_friends ON UserFbs.id = UserFbs_friends.friends_id "
			+ "WHERE UserFbs_friends.User_id = ?1" // ?1.get(id) OR ?1.id ??????
			, nativeQuery = true)
	Set<User> findFriends(int id);

	/**
	 * Native MySql
	 * @Modfying & @Transactional both needed
	 * @param id
	 * @param friend
	 */
	@Modifying
	@Transactional
	@Query(value=
			"INSERT INTO UserFbs_friends(User_id, friends_id) "
			+ "VALUES (?1, ?2)",
			nativeQuery = true)
	void addFriends(int id, User friend);
	

	/**
	 * @Query(
		  value = "SELECT * FROM USERS u WHERE u.status = 1", 
		  nativeQuery = true)
		Collection<User> findAllActiveUsersNative();
		@Query("from User u where u = %?1%")
	 * @param u
	 * @return
	 */
//	@Query("FROM Group g WHERE g.User = ?1")
//	List<Group> findAllGroupForOneUser(User u);
	
}
