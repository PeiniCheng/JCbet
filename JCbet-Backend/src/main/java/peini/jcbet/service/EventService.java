package peini.jcbet.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.BetRepository;
import peini.jcbet.dao.EventRepository;
import peini.jcbet.dao.EventTeamRepository;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;
import peini.jcbet.model.EventTeam;
import peini.jcbet.model.Team;

@Service
public class EventService {
  @Autowired
  TeamRepository teamRepository;
  @Autowired
  EventRepository eventRepository;

  @Autowired
  EventTeamRepository eventTeamRepository;

  @Autowired
  BetRepository betRepository;

  @Transactional
  public Event createEvent(String title, String description, String image, long endTime,
                           String teamAName, String teamBName) throws IllegalArgumentException {
    if (title == null || title.trim().length() == 0) {
      throw new IllegalArgumentException("empty title");
    }
    if (endTime <= System.currentTimeMillis()) {
      throw new IllegalArgumentException("invalid end time");
    }
    Event event = new Event();
    event.setTitle(title);
    event.setDescription(description);
    event.setImage(image);
    event.setEndTime(endTime);
    Team teamA = getTeam(teamAName);
    Team teamB = getTeam(teamBName);
    EventTeam eventTeamA = new EventTeam();
    eventTeamA.setTeam(teamA);
    eventTeamA.setEvent(event);
    eventTeamRepository.save(eventTeamA);
    EventTeam eventTeamB = new EventTeam();
    eventTeamB.setTeam(teamB);
    eventTeamB.setEvent(event);
    eventTeamRepository.save(eventTeamB);
    event.setTeamA(eventTeamA);
    event.setTeamB(eventTeamB);
    return eventRepository.save(event);
  }

  @Transactional
  public Event getEvent(long id) throws IllegalArgumentException {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    return event.get();
  }

  @Transactional
  public Bet getBet(long id, String email) throws IllegalArgumentException {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    Event e = event.get();
    for(Bet bet: e.getTeamA().getBetList()){
      if (bet.getUser().getEmail().equals(email)){
        return bet;
      }
    }
    for(Bet bet: e.getTeamB().getBetList()){
      if (bet.getUser().getEmail().equals(email)){
        return bet;
      }
    }
    return null;
  }

  @Transactional
  public List<Event> getAllEvents() {
    ArrayList<Event> eventList = eventRepository.findAllByOrderByEndTime();
    return eventList;
  }

  @Transactional
  public Event setEventTitle(long id, String title)
      throws IllegalArgumentException {
    if (title == null || title.trim().length() == 0) {
      throw new IllegalArgumentException("empty title");
    }
    Event event = getEvent(id);
    ;
    event.setTitle(title);
    return eventRepository.save(event);
  }

  @Transactional
  public Event setEventDescription(long id, String description)
      throws IllegalArgumentException {
    Event event = getEvent(id);
    ;
    event.setDescription(description);
    return eventRepository.save(event);
  }

  @Transactional
  public Event setEventImage(long id, String image)
      throws IllegalArgumentException {
    Event event = getEvent(id);
    ;
    event.setImage(image);
    return eventRepository.save(event);
  }

  @Transactional
  public Event setEventEndTime(long id, long endTime)
      throws IllegalArgumentException {
    Event event = getEvent(id);
    ;
    event.setEndTime(endTime);
    return eventRepository.save(event);
  }

  @Transactional
  public Event updateEvent(long id)
      throws IllegalArgumentException {
    Event event = getEvent(id);
    if(event.getEndTime() <= System.currentTimeMillis()){
      event.setStatus(Event.EventState.CLOSE);
    }
    return eventRepository.save(event);
  }

  @Transactional
  public Event setEventTeams(long id, String teamAName, String teamBName)
      throws IllegalArgumentException {
    Event event = getEvent(id);
    eventTeamRepository.delete(event.getTeamA());
    eventTeamRepository.delete(event.getTeamB());
    Team teamA = getTeam(teamAName);
    Team teamB = getTeam(teamBName);
    EventTeam eventTeamA = new EventTeam();
    eventTeamA.setTeam(teamA);
    eventTeamRepository.save(eventTeamA);
    EventTeam eventTeamB = new EventTeam();
    eventTeamB.setTeam(teamB);
    eventTeamRepository.save(eventTeamB);
    event.setTeamA(eventTeamA);
    event.setTeamB(eventTeamB);
    return eventRepository.save(event);
  }

  @Transactional
  public Event setEventResult(long eventId, long eventTeamId) throws IllegalArgumentException {
    Event event = getEvent(eventId);
    double ratio = event.calculateOdds();
    EventTeam eventTeam = getEventTeam(eventTeamId);
    EventTeam teamA = event.getTeamA();
    EventTeam teamB = event.getTeamB();
    if (eventTeam.equals(teamA)) {
      teamA.setResult(EventTeam.Result.WIN);
      teamB.setResult(EventTeam.Result.LOSE);
      for(Bet bet: teamA.getBetList()){
        bet.getUser().addToken(bet.getToken() * (1 + ratio));
      }
    } else {
      teamA.setResult(EventTeam.Result.LOSE);
      teamB.setResult(EventTeam.Result.WIN);
      for(Bet bet: teamB.getBetList()){
        bet.getUser().addToken(bet.getToken() * (1 + (1/ratio)));
      }
    }
    eventTeamRepository.save(teamA);
    eventTeamRepository.save(teamB);
    return eventRepository.save(event);
  }

  @Transactional
  public void deleteEvent(long id) throws IllegalArgumentException {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    EventTeam teamA = event.get().getTeamA();
    for(Bet bet : teamA.getBetList()){
      bet.getUser().removeBet(bet);
      betRepository.delete(bet);
    }
    EventTeam teamB = event.get().getTeamB();
    for(Bet bet : teamB.getBetList()){
      bet.getUser().removeBet(bet);
      betRepository.delete(bet);
    }
    eventTeamRepository.delete(teamA);
    eventTeamRepository.delete(teamB);
    eventRepository.delete(event.get());
  }

  private EventTeam getEventTeam(long id) throws IllegalArgumentException {
    Optional<EventTeam> eventTeam = eventTeamRepository.findById(id);
    if (eventTeam.isEmpty()) {
      throw new IllegalArgumentException("Team does not exist!");
    }
    return eventTeam.get();
  }

  private Team getTeam(String name) throws IllegalArgumentException {
    Team team = teamRepository.findByName(name);
    if (team == null) {
      throw new IllegalArgumentException("Team does not exist!");
    }
    return team;
  }
}
