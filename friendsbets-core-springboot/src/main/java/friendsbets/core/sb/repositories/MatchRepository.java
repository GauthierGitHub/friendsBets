package friendsbets.core.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
