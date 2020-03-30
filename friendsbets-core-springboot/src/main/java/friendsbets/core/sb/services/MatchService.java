package friendsbets.core.sb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void save(Match m) {
		mr.save(m);
	}

	public void delete(Match m) {
		mr.delete(m);
	}

	public void update(Match m) {
		mr.save(m);
	}

	public List<Match> findAll() {
		return mr.findAll();
	}
}
