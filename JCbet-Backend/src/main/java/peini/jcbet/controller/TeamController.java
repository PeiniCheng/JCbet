package peini.jcbet.controller;

import static peini.jcbet.dto.util.convertToDto;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import peini.jcbet.dto.TeamDto;
import peini.jcbet.model.Team;
import peini.jcbet.service.TeamService;

@CrossOrigin(origins = "*")
@RestController
public class TeamController {
  @Autowired
  private TeamService service;

  @GetMapping(value = {"/team", "/team/"})
  public List<TeamDto> getAllTeams() {
    return service.getAllTeams().stream().map(t -> convertToDto(t))
        .collect(Collectors.toList());
  }

  @GetMapping(value = {"/team/{id}", "/team/{id}/"})
  public TeamDto getTeam(@PathVariable("id") long id) {
    return convertToDto(service.getTeam(id));
  }

  @PostMapping(value = {"/team/{name}", "/user/{name}/"})
  public TeamDto createTeam(@PathVariable("name") String name, @RequestParam String image
  ) throws IllegalArgumentException {
    Team team = service.createTeam(name, image);
    return convertToDto(team);
  }

  @PatchMapping(value = {"/team/{id}/setName", "/user/{id}/setName/"})
  public TeamDto setTeamName(@PathVariable("id") long id, @RequestParam String newName
  ) throws IllegalArgumentException {
    Team team = service.setTeamName(id, newName);
    return convertToDto(team);
  }

  @PatchMapping(value = {"/team/{id}/setImage", "/user/{id}/setImage/"})
  public TeamDto setTeamImage(@PathVariable("id") long id, @RequestParam String newImage
  ) throws IllegalArgumentException {
    Team team = service.setTeamImage(id, newImage);
    return convertToDto(team);
  }

  @DeleteMapping(value = {"/team/{id}", "/user/{id}/"})
  public void deleteTeam(@PathVariable("id") long id
  ) throws IllegalArgumentException {
    service.deleteTeam(id);
  }
}
