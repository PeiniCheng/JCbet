package peini.jcbet.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Team;
import peini.jcbet.model.User;

public interface TeamRepository extends CrudRepository<Team, Long> {
  Team findByName(String name);
  ArrayList<User> findAllByOrderByName();
}
