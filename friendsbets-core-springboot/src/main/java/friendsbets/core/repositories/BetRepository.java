package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.sb.models.FbsBet;

public interface BetRepository extends JpaRepository<FbsBet, Integer>{

}
