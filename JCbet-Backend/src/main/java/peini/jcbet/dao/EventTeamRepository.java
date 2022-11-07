package peini.jcbet.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Event;
import peini.jcbet.model.EventTeam;

public interface EventTeamRepository extends CrudRepository<EventTeam, Long> {
  ArrayList<EventTeam> findByEvent(Event event);
}
