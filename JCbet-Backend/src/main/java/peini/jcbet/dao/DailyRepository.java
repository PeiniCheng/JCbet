package peini.jcbet.dao;

import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Daily;
import peini.jcbet.model.Event;
import peini.jcbet.model.User;

public interface DailyRepository extends CrudRepository<Daily, Long> {
  Daily findDailyByUser(User user);
}
