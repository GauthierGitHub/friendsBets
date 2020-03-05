package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.FbsMessage;

public interface MessageRepository extends JpaRepository<FbsMessage, Integer> {

}
