package peini.jcbet.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  private String profilePic;
  @Id
  private String email;
  private String username;
  private String password;
  private double token;

  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private List<Bet> betList;

  public User() {
    profilePic = "";
    this.email = "";
    username = "";
    password = "";
    token = 0;
  }

  public void setProfilePic(String profilePic) {
    this.profilePic = profilePic;
  }

  public String getProfilePic() {
    return profilePic;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setToken(double token) {
    this.token = token;
  }

  public void addToken(double token) {
    this.token += token;
  }

  public void deductToken(double token) {
    this.token -= token;
  }

  public double getToken() {
    return token;
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
