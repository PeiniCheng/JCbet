package peini.jcbet.dto;

public class EventTeamDto {
  private long id;

  private String result;

  private TeamDto team;

  private long event;

  public EventTeamDto(long id, String result, TeamDto team, long event) {
    this.id = id;
    this.result = result;
    this.team = team;
    this.event = event;
  }

  public long getId() {
    return id;
  }

  public String getResult() {
    return result;
  }

  public TeamDto getTeam() {
    return team;
  }

  public long getEvent() {
    return event;
  }
}
