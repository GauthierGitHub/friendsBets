package services;

import java.util.List;

import dao.FriendsBetsMatchDao;
import models.FriendsBetsMatch;

/**
 * TODO Exceptions
 * 
 * All methods what return Matchs
 * or update Matchs database
 * @author gauthier
 *
 */
public class MatchService {
	private FriendsBetsMatchDao mDao = new FriendsBetsMatchDao();	
	
	public void createMatch(FriendsBetsMatch m) throws Exception {
		mDao.save(m);
	}
	
	public void deleteMatch(FriendsBetsMatch m) throws Exception {
		mDao.delete(m);
	}
	
	public void updateMatch(FriendsBetsMatch m) throws Exception {
		mDao.update(m);
	}
	
	public List<FriendsBetsMatch> findAllMatchs() {
		return mDao.findAll();
	}
}
