package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.sb.models.Message;
import friendsbets.core.sb.repositories.MessageRepository;

/**
 * TODO Exceptions
 * 
 * All methods what return Messages or update Messages database
 * 
 * @author gauthier
 *
 */
@Service
public class MessageService {

	@Autowired
	MessageRepository mr;

	public void save(Message m) {
		mr.save(m);
	}

	public void delete(Message m) {
		mr.delete(m);
	}

	public void update(Message m) {
		mr.delete(m);
	}

	public List<Message> findAll() {
		return mr.findAll();
	}
}
