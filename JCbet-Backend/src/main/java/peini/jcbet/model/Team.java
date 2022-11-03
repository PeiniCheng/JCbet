package peini.jcbet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String image;

  public Team() {
    name = "";
    image = "";
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImage() {
    return image;
  }

  public long getId() {
    return id;
  }
}
