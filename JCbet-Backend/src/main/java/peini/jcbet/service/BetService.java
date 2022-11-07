package peini.jcbet.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.BetRepository;
import peini.jcbet.dao.EventRepository;
import peini.jcbet.dao.EventTeamRepository;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.dao.UserRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;
import peini.jcbet.model.EventTeam;
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
  EventTeamRepository eventTeamRepository;

  @Transactional
  public Bet getBet(long betId) throws IllegalArgumentException {
    Optional<Bet> bet = betRepository.findById(betId);
    if (bet.isEmpty()) {
      throw new IllegalArgumentException("Bet does not exist!");
    }
    return bet.get();
  }

  @Transactional
  public Bet createBet(String email, long eventTeamId, int amount) throws IllegalArgumentException {
    Bet bet = new Bet();
    User user = getUser(email);
    EventTeam eventTeam = getEventTeam(eventTeamId);
    bet.setChoice(eventTeam);
    bet.setUser(user);
    bet.setToken(amount);
    user.addBet(bet);
    eventTeam.addBet(bet);
    return betRepository.save(bet);
  }

  @Transactional
  public Bet setAmount(long betId, int amount) throws IllegalArgumentException{
    Bet bet = getBet(betId);
    bet.setToken(amount);
    return betRepository.save(bet);
  }

  @Transactional
  public void deleteBet(long betId) throws IllegalArgumentException {
    Optional<Bet> bet = betRepository.findById(betId);
    bet.get().getUser().removeBet(bet.get());
    bet.get().getChoice().removeBet(bet.get());
    betRepository.delete(bet.get());
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

  private EventTeam getEventTeam(long id) throws IllegalArgumentException {
    Optional<EventTeam> eventTeam = eventTeamRepository.findById(id);
    if (eventTeam.isEmpty()) {
      throw new IllegalArgumentException("Event does not exist!");
    }
    return eventTeam.get();
  }
}
