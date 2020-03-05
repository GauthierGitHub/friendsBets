package friendsbets.core.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
