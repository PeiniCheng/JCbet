package peini.jcbet.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.EventRepository;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;

public class EventService {
  @Autowired
  TeamRepository teamRepository;
  @Autowired
  EventRepository eventRepository;

  @Transactional
  public Event getEvent(long id) throws IllegalArgumentException {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    return event.get();
  }
}
