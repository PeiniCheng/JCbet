package peini.jcbet.dao;

import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Bet;

public interface BetRepository extends CrudRepository<Bet, Long> {
  Bet findBetByChoice_Id(long id);
}
