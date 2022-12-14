package peini.jcbet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.BetRepository;
import peini.jcbet.dao.DailyRepository;
import peini.jcbet.dao.UserRepository;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Daily;
import peini.jcbet.model.User;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  BetRepository betRepository;

  @Autowired
  DailyRepository dailyRepository;

  @Transactional
  public User getUser(String email) throws IllegalArgumentException {
    if (email == null || email.trim().length() == 0) {
      throw new IllegalArgumentException("empty email");
    }
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new IllegalArgumentException("User does not exist!");
    }
    return user;
  }

  @Transactional
  public Daily getDaily(User user){
    Daily daily = dailyRepository.findDailyByUser(user);
    if(daily == null){
      daily = new Daily(user);
      dailyRepository.save(daily);
    }
    return daily;
  }


  @Transactional
  public User createUser(String email) throws IllegalArgumentException {
    if (userRepository.findByEmail(email) != null) {
      throw new IllegalArgumentException("email already exists");
    }
    if (!Pattern.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", email)) {
      throw new IllegalArgumentException("invalid email");
    }
    User user = new User();
    user.setEmail(email);
    user.setUsername("null");
    user.setPassword("password");
    user.setProfilePic("null");
    user.addToken(10);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserUsername(String email, String username)
      throws IllegalArgumentException {
    if (username == null || username.trim().length() == 0) {
      throw new IllegalArgumentException("empty username");
    }
    User user = getUser(email);
    ;
    user.setUsername(username);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserPassword(String email, String password)
      throws IllegalArgumentException {
    if (password == null || password.trim().length() == 0) {
      throw new IllegalArgumentException("empty password");
    }
    User user = getUser(email);
    ;
    user.setPassword(password);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserProfilePic(String email, String path)
      throws IllegalArgumentException {
    if (path == null || path.trim().length() == 0) {
      throw new IllegalArgumentException("no image");
    }
    User user = getUser(email);
    ;
    user.setProfilePic(path);
    return userRepository.save(user);
  }

  @Transactional
  public List<Bet> getBetsByUsername(String email) throws IllegalArgumentException {
    User user = getUser(email);
    return user.getBetList();
  }

  @Transactional
  public User addToken(String email, double amount) throws IllegalArgumentException {
    User user = getUser(email);
    user.addToken(amount);
    return userRepository.save(user);
  }

  @Transactional
  public User deductToken(String email, double amount) throws IllegalArgumentException {
    User user = getUser(email);
    user.deductToken(amount);
    return userRepository.save(user);
  }

  @Transactional
  public void deleteUser(String email) throws IllegalArgumentException {
    User user = getUser(email);
    for (Bet bet : user.getBetList()) {
      if(bet.getChoice() != null) bet.getChoice().removeBet(bet);
      betRepository.delete(bet);
    }
    Daily daily = getDaily(user);
    dailyRepository.delete(daily);
    userRepository.delete(user);
  }

  public boolean isDailyValid(String email){
    User user = getUser(email);
    Daily daily = getDaily(user);
    return daily.isValid();
  }

  public void claim(String email){
    User user = getUser(email);
    Daily daily = getDaily(user);
    daily.claim();
    dailyRepository.save(daily);
  }

  @Transactional
  public List<User> getAllUsers() {
    ArrayList<User> userList = userRepository.findAllByOrderByUsername();
    return userList;
  }

  @Transactional
  public List<User> getTopUsers() {
    ArrayList<User> userList = userRepository.findAllByOrderByTokenDesc();
    return userList;
  }
}
