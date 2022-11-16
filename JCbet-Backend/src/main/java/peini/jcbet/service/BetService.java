package peini.jcbet.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.BetRepository;
import peini.jcbet.dao.EventTeamRepository;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.dao.UserRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.EventTeam;
import peini.jcbet.model.User;

@Service
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
    user.deductToken(amount);
    eventTeam.addBet(bet);
    return betRepository.save(bet);
  }

  @Transactional
  public Bet setAmount(long betId, int amount) throws IllegalArgumentException {
    Bet bet = getBet(betId);
    User user = bet.getUser();
    user.addToken(bet.getToken());
    bet.setToken(amount);
    user.deductToken(amount);
    userRepository.save(user);
    return betRepository.save(bet);
  }

  @Transactional
  public void deleteBet(long betId) throws IllegalArgumentException {
    Optional<Bet> bet = betRepository.findById(betId);
    Bet b = bet.get();
    b.getUser().removeBet(bet.get());
    b.getChoice().removeBet(bet.get());
    b.getUser().addToken(b.getToken());
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
      throw new IllegalArgumentException("Team does not exist!");
    }
    return eventTeam.get();
  }
}
