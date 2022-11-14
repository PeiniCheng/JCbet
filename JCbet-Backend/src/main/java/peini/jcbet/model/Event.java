package peini.jcbet.model;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Event {
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private String description;
  private String image;
  private long endTime;
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private EventTeam teamA;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private EventTeam teamB;

  private EventState status;

  public enum EventState {
    OPEN, CLOSE

  }

  public Event() {
    this.status = EventState.OPEN;
  }

  public long getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setTeamA(EventTeam team) {
    this.teamA = team;
  }

  public EventTeam getTeamA() {
    return teamA;
  }

  public void setTeamB(EventTeam team) {
    this.teamB = team;
  }

  public EventTeam getTeamB() {
    return teamB;
  }

  public void setStatus(EventState status) {
    this.status = status;
  }

  public EventState getStatus() {
    return status;
  }

  public double calculateOdds(){
    int a = 0;
    int b = 0;
    for(Bet bet : teamA.getBetList()){
      a+= bet.getToken();
    }
    for(Bet bet : teamB.getBetList()){
      b+= bet.getToken();
    }
    if(a==0 || b==0){
      return -1;
    }else{
      return (double)b/a;
    }
  }
}
