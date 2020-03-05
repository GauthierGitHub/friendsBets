package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.exceptions.SqlUniqueContraintException;
import friendsbets.core.sb.models.Match;
import friendsbets.core.sb.repositories.MatchRepository;

/**
 * TODO Exceptions
 * 
 * All methods what return Matchs or update Matchs database
 * 
 * @author gauthier
 *
 */
@Service
public class MatchService {

	@Autowired
	MatchRepository mr;

	public void createMatch(Match m) throws SqlUniqueContraintException {
		mr.save(m);
	}

	public void deleteMatch(Match m) throws SqlNotFoundException {
		mr.delete(m);
	}

	public void updateMatch(Match m) throws SqlNotFoundException {
		mr.save(m);
	}

	public List<Match> findAllMatchs() {
		return mr.findAll();
	}
}
