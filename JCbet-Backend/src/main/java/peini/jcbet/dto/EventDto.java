package peini.jcbet.dto;

import java.sql.Date;

public class EventDto {
  private long id;
  private String title;
  private String description;
  private String image;
  private Date endTime;
  private EventTeamDto teamA;
  private EventTeamDto teamB;
  private String status;

  public EventDto(long id, String title, String description, String image, Date endTime, EventTeamDto teamA, EventTeamDto teamB, String status){
    this.id = id;
    this.title = title;
    this.description = description;
    this.image = image;
    this.endTime = endTime;
    this.teamA = teamA;
    this.teamB = teamB;
    this.status = status;
  }
}
