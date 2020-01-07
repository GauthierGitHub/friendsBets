package services;

import java.util.List;

import dao.FriendsBetsMessageDao;
import models.FriendsBetsMessage;

public class MessageService {
	private FriendsBetsMessageDao mDao = new FriendsBetsMessageDao();	
	
	public void createGroup(FriendsBetsMessage m) throws Exception {
		mDao.save(m);
	}
	
	public void deleteGroup(FriendsBetsMessage m) throws Exception {
		mDao.delete(m);
	}
	
	public void updateGroup(FriendsBetsMessage m) throws Exception {
		mDao.update(m);
	}
	
	public List<FriendsBetsMessage> findAllGroups() {
		return mDao.findAll();
	}
}
