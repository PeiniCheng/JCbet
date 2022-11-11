package peini.jcbet.dto;

import java.util.List;
import peini.jcbet.model.Bet;
import peini.jcbet.model.Event;
import peini.jcbet.model.EventTeam;
import peini.jcbet.model.Team;

public class EventTeamDto{
    private long id;

    private String result;

    private TeamDto team;

    private String event;

    public EventTeamDto(long id, String result, TeamDto team, String event){
      this.id = id;
      this.result = result;
      this.team = team;
      this.event = event;
    }
}
