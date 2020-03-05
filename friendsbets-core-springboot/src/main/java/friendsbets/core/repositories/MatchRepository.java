package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.FbsMatch;

public interface MatchRepository extends JpaRepository<FbsMatch, Integer> {

}
