package services;

import java.util.List;

import dao.MatchDao;
import exceptions.SqlNotFoundException;
import exceptions.SqlUniqueContraintException;
import models.FbsMatch;

/**
 * TODO Exceptions
 * 
 * All methods what return Matchs
 * or update Matchs database
 * @author gauthier
 *
 */
public class MatchService {
	private MatchDao mDao = new MatchDao();	
	
	public void createMatch(FbsMatch m) throws SqlUniqueContraintException {
		try {
			mDao.save(m);
		} catch (Exception e) {
			throw new SqlUniqueContraintException(e, m);
		}
	}
	
	public void deleteMatch(FbsMatch m) throws SqlNotFoundException {
		try {
			mDao.delete(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public void updateMatch(FbsMatch m) throws SqlNotFoundException {
		try {
			mDao.update(m);
		} catch (Exception e) {
			throw new SqlNotFoundException(e, m);
		}
	}
	
	public List<FbsMatch> findAllMatchs() {
		return mDao.findAll();
	}
}
