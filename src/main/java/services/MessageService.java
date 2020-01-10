package services;

import java.util.List;

import dao.FriendsBetsMessageDao;
import exceptions.FriendsBetsException;
import exceptions.SqlNotFoundException;
import models.FriendsBetsMessage;

/**
 * TODO Exceptions
 * 
 * All methods what return Messages
 * or update Messages database
 * @author gauthier
 *
 */
public class MessageService {
	private FriendsBetsMessageDao mDao = new FriendsBetsMessageDao();	
	
	public void createMessage(FriendsBetsMessage m) throws FriendsBetsException {
		try {
			mDao.save(m);
		} catch (Exception e) { //no unique contraint
			throw new FriendsBetsException(m);
		}
	}
	
	public void deleteMessage(FriendsBetsMessage m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public void updateMessage(FriendsBetsMessage m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public List<FriendsBetsMessage> findAllGMessages() {
		return mDao.findAll();
	}
}
