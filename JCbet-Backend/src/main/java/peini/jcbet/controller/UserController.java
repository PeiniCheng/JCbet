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
import peini.jcbet.dto.UserDto;
import peini.jcbet.model.User;
import peini.jcbet.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
  @Autowired
  private UserService service;

  @GetMapping(value = {"/user", "/user/"})
  public List<UserDto> getAllUsers() {
    return service.getAllUsers().stream().map(p -> convertToDto(p))
        .collect(Collectors.toList());
  }

  @GetMapping(value = {"/user/ranking", "/user/ranking/"})
  public List<UserDto> getTopUsers() {
    return service.getTopUsers().stream().map(p -> convertToDto(p))
        .collect(Collectors.toList());
  }

  @PostMapping(value = {"/user/{email}", "/user/{email}/"})
  public UserDto createUser(@PathVariable("email") String email
  ) throws IllegalArgumentException {
    User user = service.createUser(email);
    return convertToDto(user);
  }

  @GetMapping(value = {"/user/{email}", "/user/{email}/"})
  public UserDto getUser(@PathVariable("email") String email)
      throws IllegalArgumentException {
    return convertToDto(service.getUser(email));
  }

  @GetMapping(value = {"/user/{email}/daily", "/user/{email}/daily/"})
  public boolean isDailyValid(@PathVariable("email") String email)
      throws IllegalArgumentException {
    return service.isDailyValid(email);
  }

  @PatchMapping(value = {"/user/{email}/claim", "/user/{email}/claim/"})
  public void claimDaily(@PathVariable("email") String email)
      throws IllegalArgumentException {
    service.claim(email);
  }

  @PatchMapping(value = {"/user/{email}/username", "/user/{email}/username/"})
  public UserDto updateUsername(@PathVariable("email") String email,
                                @RequestParam String newName)
      throws IllegalArgumentException {
    User user = service.getUser(email);
    user = service.setUserUsername(email, newName);
    return convertToDto(user);
  }

  @PatchMapping(value = {"/user/{email}/password", "/user/{email}/password/"})
  public UserDto updatePassword(@PathVariable("email") String email,
                                @RequestParam String newPassword)
      throws IllegalArgumentException {
    User user = service.getUser(email);
    user = service.setUserPassword(email, newPassword);
    return convertToDto(user);
  }

  @PatchMapping(value = {"/user/{email}/profilePic", "/user/{email}/profilePic/"})
  public UserDto updateProfilePic(@PathVariable("email") String email,
                                  @RequestParam String newProfilePic)
      throws IllegalArgumentException {
    User user = service.getUser(email);
    user = service.setUserProfilePic(email, newProfilePic);
    return convertToDto(user);
  }

  @PatchMapping(value = {"/user/{email}/addToken", "/user/{email}/addToken/"})
  public UserDto addToken(@PathVariable("email") String email,
                          @RequestParam double token)
      throws IllegalArgumentException {
    User user = service.getUser(email);
    user = service.addToken(email, token);
    return convertToDto(user);
  }

  @PatchMapping(value = {"/user/{email}/deductToken", "/user/{email}/deductToken/"})
  public UserDto deductToken(@PathVariable("email") String email,
                             @RequestParam double token)
      throws IllegalArgumentException {
    User user = service.getUser(email);
    user = service.deductToken(email, token);
    return convertToDto(user);
  }

  @DeleteMapping(value = {"/user/{email}", "/user/{email}/"})
  public void deleteUser(@PathVariable("email") String email)
      throws IllegalArgumentException {
    service.deleteUser(email);
  }
}
