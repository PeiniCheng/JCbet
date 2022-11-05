package peini.jcbet.service;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peini.jcbet.dao.UserRepository;
import peini.jcbet.model.User;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  @Transactional
  public User createUser(String email) throws IllegalArgumentException {
    if (userRepository.findByEmail(email) != null) {
      throw new IllegalArgumentException("email already exists");
    }
    if(Pattern.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", email)){
      throw new IllegalArgumentException("invalid email");
    }
    User user = new User();
    user.setEmail(email);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserUsername(String email, String username)
      throws IllegalArgumentException {
    if (username == null || username.trim().length() == 0) {
      throw new IllegalArgumentException("empty username");
    }
    User user = userRepository.findByEmail(email);
    user.setUsername(username);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserPassword(String email, String password)
      throws IllegalArgumentException {
    if (password == null || password.trim().length() == 0) {
      throw new IllegalArgumentException("empty password");
    }
    User user = userRepository.findByEmail(email);
    user.setPassword(password);
    return userRepository.save(user);
  }

  @Transactional
  public User setUserProfilePic(String email, String path)
      throws IllegalArgumentException {
    if (path == null || path.trim().length() == 0) {
      throw new IllegalArgumentException("no image");
    }
    User user = userRepository.findByEmail(email);
    user.setProfilePic(path);
    return userRepository.save(user);
  }
}