package peini.jcbet.dao;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import peini.jcbet.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
  Team findByName(String name);

  ArrayList<Team> findAllByOrderByName();
}
