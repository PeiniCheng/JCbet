package peini.jcbet.dto;

public class TeamDto {
  private long id;
  private String name;
  private String image;

  public TeamDto(long id, String name, String image){
    this.id = id;
    this.name = name;
    this.image = image;
  }
}
