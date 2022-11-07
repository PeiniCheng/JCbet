package peini.jcbet.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Event;
import peini.jcbet.model.Event.EventState;

public interface EventRepository extends CrudRepository<Event, Long> {
  Event findByTitle(String title);
  ArrayList<Event> findByState(EventState state);
}
