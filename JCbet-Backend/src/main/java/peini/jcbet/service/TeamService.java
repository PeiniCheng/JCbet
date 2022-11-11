package peini.jcbet.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import peini.jcbet.dao.TeamRepository;
import peini.jcbet.model.Team;

public class TeamService {
  @Autowired
  TeamRepository teamRepository;

  public Team createTeam(String name, String image){
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException("name");
    }
    Team team = new Team();
    team.setName(name);
    team.setImage(image);
    return teamRepository.save(team);
  }

  public Team getTeam(long id) throws IllegalArgumentException{
    Optional<Team> team = teamRepository.findById(id);
    if (team.isEmpty()) {
      throw new IllegalArgumentException("Team does not exist!");
    }
    return team.get();
  }

  public Team setTeamName(long id, String name) throws IllegalArgumentException{
    Team team = getTeam(id);
    team.setName(name);
    return teamRepository.save(team);
  }

  public Team setTeamImage(long id, String image) throws IllegalArgumentException{
    Team team = getTeam(id);
    team.setImage(image);
    return teamRepository.save(team);
  }

  public void deleteTeam(long id) throws IllegalArgumentException{
    Team team = getTeam(id);
    teamRepository.delete(team);
  }
}
