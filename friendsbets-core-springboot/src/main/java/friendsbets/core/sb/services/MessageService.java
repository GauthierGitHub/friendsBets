package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import friendsbets.core.sb.exceptions.SqlNotFoundException;
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
public class MessageService {

	@Autowired
	MessageRepository mr;

	public void createMessage(Message m) {
		mr.save(m);
	}

	public void deleteMessage(Message m) throws SqlNotFoundException {
		mr.delete(m);
	}

	public void updateMessage(Message m) throws SqlNotFoundException {
		mr.delete(m);
	}

	public List<Message> findAllMessages() {
		return mr.findAll();
	}
}
