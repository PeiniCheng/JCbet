package peini.jcbet.dto;

public class EventTeamDto {
  private long id;

  private String result;

  private TeamDto team;

  private long eventId;

  private String eventTitle;
  public EventTeamDto(long id, String result, TeamDto team, long eventId, String eventTitle) {
    this.id = id;
    this.result = result;
    this.team = team;
    this.eventId = eventId;
    this.eventTitle = eventTitle;
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

  public long getEventId() {
    return eventId;
  }

  public String getEventTitle() {
    return eventTitle;
  }
}
