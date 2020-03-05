package friendsbets.core.repositories;

import friendsbets.core.sb.models.FbsUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<FbsUser, Integer> {

}
