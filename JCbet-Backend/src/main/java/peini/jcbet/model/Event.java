package peini.jcbet.model;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private String description;
  private String image;
  private Date startTime;
  private Date endTime;
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<Team> teamSet;
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<User> userSet;
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Set<Bet> betSet;
  private EventStatus status;

  public Event() {
    this.status = EventStatus.OPEN;
    this.startTime = new Date(System.currentTimeMillis());
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

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setTeam(Set<Team> teamSet) {
    this.teamSet = teamSet;
  }

  public void addTeam(Team team) {
    this.teamSet.add(team);
  }

  public boolean removeTeam(Team team) {
    return this.teamSet.remove(team);
  }

  public Set<Team> getTeamSet() {
    return teamSet;
  }

  public void setStatus(EventStatus status) {
    this.status = status;
  }

  public EventStatus getStatus() {
    return status;
  }

  public void setUserSet(Set<User> userSet) {
    this.userSet = userSet;
  }

  public void addUser(User user) {
    userSet.add(user);
  }

  public Set<User> getUserSet() {
    return userSet;
  }

  public void setBetSet(Set<Bet> betSet) {
    this.betSet = betSet;
  }

  public Set<Bet> getBetSet() {
    return betSet;
  }
}
