package friendsbets.core.sb.repositories;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import friendsbets.core.sb.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);

	// TODO: my Query ?
	@Query("from User u where u.nickname like %?1% or u.email like %?1%")
	Set<User> findByNicknameOrEmailLike(String pattern);

	// native sql
	@Query(value=
			"SELECT * "
			+ "FROM UserFbs "
			+ "WHERE id != ?1"
			, nativeQuery = true)
	Set<User> findAllOthers(int id); // or User u ?
	
	// jpql & springboot
//	@Query("FROM User u WHERE u != ?1")
//	Set<User> findAllOthers(User u);

	// native sql
	@Query(value=
			"SELECT * "
			+ "FROM UserFbs "
			+ "RIGHT JOIN UserFbs_friends ON UserFbs.id = UserFbs_friends.friends_id "
			+ "WHERE UserFbs_friends.User_id = ?1" // ?1.get(id) OR ?1.id ??????
			, nativeQuery = true)
	Set<User> findFriends(int id);

	// JPQL
//	@Query("UPDATE User u SET u.friends = ?2 WHERE u.id = ?1")
//	void addFriends(int id, HashSet<User> friends);

	// Native Sql
	@Modifying
	@Transactional
	@Query(value=
			"INSERT INTO UserFbs_friends(User_id, friends_id) "
			+ "VALUES (?1, ?2)",
			nativeQuery = true)
	void addFriends(int id, User friend);
	
//	Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = ?");
//	q.setParameter(1, 1);
//	Object[] author = (Object[]) q.getSingleResult();
	
//	@Query("FROM User.friends u where u = ?1")
//	Set<User> findFriends(User u);

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
	
}
