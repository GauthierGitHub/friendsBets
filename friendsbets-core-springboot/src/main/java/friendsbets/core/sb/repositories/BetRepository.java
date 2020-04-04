package friendsbets.core.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{

}
