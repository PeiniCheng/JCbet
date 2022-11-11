package peini.jcbet.dto;

import java.util.List;

public class UserDto {
  private String email;
  private String username;
  private String password;
  private String profilePic;
  private double token;
  private List<BetDto> betList;

  public UserDto(String email, String username, String password, String profilePic, double token, List<BetDto> betList){
    this.profilePic = profilePic;
    this.email = email;
    this.username = username;
    this.password = password;
    this.token = token;
    this.betList = betList;
  }
}
