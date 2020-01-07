package services;

import java.util.List;

import dao.FriendsBetsMessageDao;
import exceptions.EmptyMessageException;
import models.FriendsBetsMessage;

/**
 * TODO Exceptions
 * 
 * All methods what return Messages
 * @author gauthier
 *
 */
public class MessageService {
	private FriendsBetsMessageDao mDao = new FriendsBetsMessageDao();	
	
	public void createMessage(FriendsBetsMessage m) throws EmptyMessageException {
		try {
			mDao.save(m);
		} catch (Exception e) {
			throw new EmptyMessageException();
		}
	}
	
	public void deleteMessage(FriendsBetsMessage m) throws Exception {
		mDao.delete(m);
	}
	
	public void updateMessage(FriendsBetsMessage m) throws Exception {
		mDao.update(m);
	}
	
	public List<FriendsBetsMessage> findAllGMessages() {
		return mDao.findAll();
	}
}
