package friendsbets.core.sb.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import friendsbets.core.sb.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

	@Query(value =
			"SELECT * FROM GroupFbs "
			+ "INNER JOIN GroupFbs_userList ON GroupFbs.id = GroupFbs_userList.grpList_id "
			+ "WHERE userList_id = ?1"
			, nativeQuery = true)
	Set<Group> findAllForOneUser(long id);



}
