package peini.jcbet.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.BetRepository;
import peini.jcbet.dao.EventRepository;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.dao.UserRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;
import peini.jcbet.model.Team;
import peini.jcbet.model.User;

public class BetService {
  @Autowired
  BetRepository betRepository;
  @Autowired
  TeamRepository teamRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  EventRepository eventRepository;

  @Transactional
  public Bet getBet(long betId) throws IllegalArgumentException {
    Optional<Bet> bet = betRepository.findById(betId);
    if (bet.isEmpty()) {
      throw new IllegalArgumentException("Bet does not exist!");
    }
    return bet.get();
  }

  @Transactional
  public Bet createBet(String email, String choice, long eventId, int amount) throws IllegalArgumentException {
    Bet bet = new Bet();
    User user = getUser(email);
    Event event = getEvent(eventId);
    Team team = getTeam(choice);
    bet.setEvent(event);
    bet.setChoice(team);
    bet.setUser(user);
    bet.setToken(amount);
    return betRepository.save(bet);
  }

  @Transactional
  public Bet setAmount(long betId, int amount) throws IllegalArgumentException{
    Bet bet = getBet(betId);
    bet.setToken(amount);
    return betRepository.save(bet);
  }

  private User getUser(String email) throws IllegalArgumentException {
    if (email == null || email.trim().length() == 0) {
      throw new IllegalArgumentException("empty email");
    }
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new IllegalArgumentException("User does not exist!");
    }
    return user;
  }

  private Team getTeam(String name) throws IllegalArgumentException {
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException("empty name");
    }
    Team team = teamRepository.findByName(name);
    if (team == null) {
      throw new IllegalArgumentException("Team does not exist!");
    }
    return team;
  }

  private Event getEvent(long id) throws IllegalArgumentException {
    Optional<Event> event = eventRepository.findById(id);
    if (event.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    return event.get();
  }
}
