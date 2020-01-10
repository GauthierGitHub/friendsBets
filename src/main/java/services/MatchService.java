package services;

import java.util.List;

import dao.FriendsBetsMatchDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
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
	
	public void createMatch(FriendsBetsMatch m) throws SqlUniqueContraintException {
		try {
			mDao.save(m);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, m);
		}
	}
	
	public void deleteMatch(FriendsBetsMatch m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public void updateMatch(FriendsBetsMatch m) throws SqlNotFoundException {
		try {
			mDao.update(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public List<FriendsBetsMatch> findAllMatchs() {
		return mDao.findAll();
	}
}
