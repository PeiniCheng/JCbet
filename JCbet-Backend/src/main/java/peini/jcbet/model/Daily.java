package peini.jcbet.model;

import static java.lang.System.currentTimeMillis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Daily {
  @Id
  @GeneratedValue
  private long id;
  private long miliseconds;

  @OneToOne
  private User user;

  public Daily(User user){
    this.miliseconds = 0;
    this.user = user;
  }

  public boolean isValid(){
    return currentTimeMillis() - this.miliseconds > 6000;
  }
}
