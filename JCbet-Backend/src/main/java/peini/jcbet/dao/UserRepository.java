package peini.jcbet.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.User;

public interface UserRepository extends CrudRepository<User, String> {
  User findByUsername(String username);

  User findByEmail(String email);

  ArrayList<User> findAllByOrderByUsername();
  ArrayList<User> findAllByOrderByTokenDesc();

}
