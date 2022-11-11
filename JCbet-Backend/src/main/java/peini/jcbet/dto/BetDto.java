package peini.jcbet.dto;


public class BetDto {
  private long id;
  private EventTeamDto choice;
  private int token;
  private String user;

  public BetDto(long id, EventTeamDto choice, int token, String user){
    this.id = id;
    this.choice = choice;
    this.token = token;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public EventTeamDto getChoice() {
    return choice;
  }

  public int getToken() {
    return token;
  }

  public String getUser() {
    return user;
  }
}
