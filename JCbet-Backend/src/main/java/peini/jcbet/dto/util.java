package peini.jcbet.dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;
import peini.jcbet.model.EventTeam;
import peini.jcbet.model.Team;
import peini.jcbet.model.User;
import peini.jcbet.service.BetService;
import peini.jcbet.service.UserService;

public class util {
  @Autowired
  private UserService userService;

  @Autowired
  private BetService betService;

  public static UserDto convertToDto(User u) throws IllegalArgumentException {
    if (u == null) {
      throw new IllegalArgumentException("There is no such User!");
    }
    UserDto customerDto =
        new UserDto(u.getEmail(), u.getUsername(), u.getPassword(), u.getProfilePic(), u.getToken(),
            createBetDtoList(u));
    return customerDto;
  }

  public static BetDto convertToDto(Bet b) throws IllegalArgumentException {
    if (b == null) {
      throw new IllegalArgumentException("There is no bet!");
    }
    BetDto betDto =
        new BetDto(b.getId(), convertToDto(b.getChoice()), b.getToken(), b.getUser().getEmail());
    return betDto;
  }

  public static EventDto convertToDto(Event e) throws IllegalArgumentException {
    if (e == null) {
      throw new IllegalArgumentException("There is no event!");
    }
    EventDto eventDto =
        new EventDto(e.getId(), e.getTitle(), e.getDescription(), e.getImage(), e.getEndTime(),
            convertToDto(e.getTeamA()), convertToDto(e.getTeamB()), e.getStatus().name());
    return eventDto;
  }

  public static TeamDto convertToDto(Team t) throws IllegalArgumentException {
    if (t == null) {
      throw new IllegalArgumentException("There is no team!");
    }
    TeamDto betDto = new TeamDto(t.getId(), t.getName(), t.getImage());
    return betDto;
  }

  public static EventTeamDto convertToDto(EventTeam et) throws IllegalArgumentException {
    if (et == null) {
      throw new IllegalArgumentException("There is no team!");
    }
    EventTeamDto betDto =
        new EventTeamDto(et.getId(), et.getResult().name(), convertToDto(et.getTeam()),
            et.getEvent().getTitle());
    return betDto;
  }

  public static List<BetDto> createBetDtoList(User u) {
    List<Bet> betList = u.getBetList();
    List<BetDto> bets = new ArrayList<>();
    for (Bet bet : betList) {
      bets.add(convertToDto(bet));
    }
    return bets;
  }
}
