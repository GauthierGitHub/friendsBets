package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
