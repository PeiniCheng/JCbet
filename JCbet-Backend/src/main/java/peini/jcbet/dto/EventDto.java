package peini.jcbet.dto;

import java.sql.Date;

public class EventDto {
  private long id;
  private String title;
  private String description;
  private String image;
  private long endTime;
  private EventTeamDto teamA;
  private EventTeamDto teamB;
  private String status;

  public EventDto(long id, String title, String description, String image, long endTime,
                  EventTeamDto teamA, EventTeamDto teamB, String status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.image = image;
    this.endTime = endTime;
    this.teamA = teamA;
    this.teamB = teamB;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public String getTitle(){
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getImage() {
    return image;
  }

  public long getEndTime() {
    return endTime;
  }

  public EventTeamDto getTeamA(){
    return teamA;
  }

  public EventTeamDto getTeamB() {
    return teamB;
  }

  public String getStatus() {
    return status;
  }
}
