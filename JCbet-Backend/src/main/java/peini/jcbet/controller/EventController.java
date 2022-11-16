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
import peini.jcbet.dto.EventDto;
import peini.jcbet.model.Event;
import peini.jcbet.service.EventService;

@CrossOrigin(origins = "*")
@RestController
public class EventController {
  @Autowired
  private EventService service;

  @GetMapping(value = {"/event", "/event/"})
  public List<EventDto> getAllEvents() {
    return service.getAllEvents().stream().map(e -> convertToDto(e))
        .collect(Collectors.toList());
  }

  @GetMapping(value = {"/event/{id}", "/event/{id}/"})
  public EventDto getEvent(@PathVariable("id") long id) {
    service.updateEvent(id);
    return convertToDto(service.getEvent(id));
  }

  @PostMapping(value = {"/event/{title}", "/event/{title}/"})
  public EventDto createEvent(@PathVariable("title") String title, @RequestParam String description,
                              @RequestParam String image, @RequestParam long endTime,
                              @RequestParam String teamAName, @RequestParam String teamBName
  ) throws IllegalArgumentException {
    Event event = service.createEvent(title, description, image, endTime, teamAName, teamBName);
    return convertToDto(event);
  }

  @PatchMapping(value = {"/event/{id}/setTitle", "/event/{id}/setTitle/"})
  public EventDto setEventTitle(@PathVariable("id") long id, @RequestParam String newTitle
  ) throws IllegalArgumentException {
    Event event = service.setEventTitle(id, newTitle);
    return convertToDto(event);
  }

  @PatchMapping(value = {"/event/{id}/setDescription", "/event/{id}/setDescription/"})
  public EventDto setEventDescription(@PathVariable("id") long id,
                                      @RequestParam String newDescription
  ) throws IllegalArgumentException {
    Event event = service.setEventDescription(id, newDescription);
    return convertToDto(event);
  }

  @PatchMapping(value = {"/event/{id}/setImage", "/event/{id}/setImage/"})
  public EventDto setEventImage(@PathVariable("id") long id, @RequestParam String newImage
  ) throws IllegalArgumentException {
    Event event = service.setEventImage(id, newImage);
    return convertToDto(event);
  }

  @PatchMapping(value = {"/event/{id}/setEndTime", "/event/{id}/setEndTime/"})
  public EventDto setEventEndTime(@PathVariable("id") long id, @RequestParam long newEndTime
  ) throws IllegalArgumentException {
    Event event = service.setEventEndTime(id, newEndTime);
    return convertToDto(event);
  }

  @PatchMapping(value = {"/event/{id}/setTeams", "/event/{id}/setTeams/"})
  public EventDto setEventTeams(@PathVariable("id") long id, @RequestParam String newTeamA,
                                @RequestParam String newTeamB
  ) throws IllegalArgumentException {
    Event event = service.setEventTeams(id, newTeamA, newTeamB);
    return convertToDto(event);
  }

  @DeleteMapping(value = {"/event/{id}", "/event/{id}/"})
  public void deleteEvent(@PathVariable("id") long id
  ) throws IllegalArgumentException {
    service.deleteEvent(id);
  }
}
