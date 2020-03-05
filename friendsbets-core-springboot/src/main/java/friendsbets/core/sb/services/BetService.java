package friendsbets.core.sb.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.repositories.BetRepository;
import friendsbets.core.sb.exceptions.SqlNotFoundException;
import friendsbets.core.sb.exceptions.SqlUniqueContraintException;
import friendsbets.core.sb.models.Bet;

/**
 * TODO Exceptions
 * 
 * All methods what return Bets or update bet database
 * 
 * @author gauthier
 *
 */
@Service
public class BetService {

	@Autowired
	BetRepository br;

	// TODO: VALIDATOR
	/**
	 * 
	 * public static final transient Validator<Member> VALIDATOR = new
	 * Validator<Member>() .addRule("alias", "Alias \"Pierre\" is not allowed !", me
	 * -> !me.getAlias().toLowerCase().equals("pierre")) .addRule("alias", "Alias
	 * must be at least 8 characters long", me -> me.getAlias().length() >= 8)
	 * .addRule("email", "invalid email format", me -> me.getEmail().contains("@"))
	 * .addRule("password", "Password must be at least 8 characters long", me ->
	 * me.getPassword().length() >= 8);
	 * 
	 * @param b
	 * @throws SqlUniqueContraintException
	 */

	// TODO: ASPECTS
	public void createBet(Bet b) throws SqlUniqueContraintException {
		br.save(b);
	}

	public void deleteBet(Bet b) throws SqlNotFoundException {
		br.delete(b);
	}

	public void updateBet(Bet b) throws SqlNotFoundException {
		br.save(b);
	}

	public List<Bet> findAllBets() {
		return br.findAll();
	}
}
