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
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Team choice;
  private int token;
  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private User user;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Event event;

  public Bet() {

  }

  public long getId() {
    return id;
  }

  public void setChoice(Team choice) {
    this.choice = choice;
  }

  public Team getChoice() {
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

  public void setEvent(Event event) {
    this.event = event;
  }

  public Event getEvent(){
    return event;
  }
}
