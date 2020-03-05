package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.FbsGroup;

public interface GroupRepository extends JpaRepository<FbsGroup, Integer> {

}
