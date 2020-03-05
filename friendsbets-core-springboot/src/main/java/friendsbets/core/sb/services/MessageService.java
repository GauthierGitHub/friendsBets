package friendsbets.core.sb.services;

import java.util.List;

import dao.MessageDao;
import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.models.FbsMessage;

/**
 * TODO Exceptions
 * 
 * All methods what return Messages
 * or update Messages database
 * @author gauthier
 *
 */
public class MessageService {
	private MessageDao mDao = new MessageDao();	
	
	public void createMessage(FbsMessage m) {
		try {
			mDao.save(m);
		} catch (Exception e) { //no unique contraint
			e.printStackTrace();
		}
	}
	
	public void deleteMessage(FbsMessage m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public void updateMessage(FbsMessage m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public List<FbsMessage> findAllMessages() {
		return mDao.findAll();
	}
}
