package peini.jcbet.model;

import java.sql.Date;
import java.util.List;
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
  private List<Team> teamList;
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private List<User> userList;
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private List<Bet> betList;
  private EventStatus status;

  enum EventStatus {
    OPEN, START, CLOSE, END

  }

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

  public void setTeam(List<Team> teamList) {
    this.teamList = teamList;
  }

  public void addTeam(Team team) {
    this.teamList.add(team);
  }

  public boolean removeTeam(Team team) {
    return this.teamList.remove(team);
  }

  public List<Team> getTeamList() {
    return teamList;
  }

  public void setStatus(EventStatus status) {
    this.status = status;
  }

  public EventStatus getStatus() {
    return status;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public void addUser(User user) {
    userList.add(user);
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setBetList(List<Bet> betList) {
    this.betList = betList;
  }

  public List<Bet> getBetList() {
    return betList;
  }
}
