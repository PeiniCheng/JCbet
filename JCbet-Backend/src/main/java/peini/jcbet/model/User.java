package peini.jcbet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
  private String profilePic;
  @Id
  private String email;
  private String username;
  private String password;
  private int token;

  public User(String email) {
    profilePic = "";
    this.email = email;
    username = "";
    password = "";
    token = 0;
  }

  public User() {

  }

  public void setProfilePic(String profilePic) {
    this.profilePic = profilePic;
  }

  public String getProfilePic() {
    return profilePic;
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

  public void setToken(int token) {
    this.token = token;
  }

  public void addToken(int token) {
    this.token += token;
  }

  public void deductToken(int token) {
    this.token -= token;
  }

  public int getToken() {
    return token;
  }
}
