package peini.jcbet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bet {
  @Id
  @GeneratedValue
  private long id;
  @OneToOne(fetch = FetchType.EAGER)
  private EventTeam choice;
  private int token;
  @OneToOne(fetch = FetchType.EAGER)
  private User user;

  public Bet() {

  }

  public long getId() {
    return id;
  }

  public void setChoice(EventTeam choice) {
    this.choice = choice;
  }

  public EventTeam getChoice() {
    return choice;
  }

  public void setToken(int token) {
    this.token = token;
  }

  public int getToken() {
    return token;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

}
