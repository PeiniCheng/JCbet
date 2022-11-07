package peini.jcbet.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EventTeam {
  @Id
  @GeneratedValue
  private long id;

  private Result result;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Team team;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private Event event;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<Bet> betList;

  public enum Result{
    NA, WIN, LOSE
  }

  public EventTeam(){
    result = Result.NA;
  }

  public long getId() {
    return id;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Event getEvent() {
    return event;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Team getTeam() {
    return team;
  }

  public Result getResult(){
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public List<Bet> getBetList() {
    return betList;
  }

  public void setBetList(List<Bet> betList) {
    this.betList = betList;
  }

  public void addBet(Bet bet){
    betList.add(bet);
  }

  public void removeBet(Bet bet){
    betList.remove(bet);
  }
}

