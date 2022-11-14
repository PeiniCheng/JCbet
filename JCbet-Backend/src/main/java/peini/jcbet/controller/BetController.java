package peini.jcbet.controller;

import static peini.jcbet.dto.util.convertToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import peini.jcbet.dto.BetDto;
import peini.jcbet.model.Bet;
import peini.jcbet.service.BetService;

@CrossOrigin(origins = "*")
@RestController
public class BetController {
  @Autowired
  private BetService service;

  @PostMapping(value = {"/bet", "/bet/"})
  public BetDto createBet(@RequestParam String email, @RequestParam long teamId, @RequestParam int amount
  ) throws IllegalArgumentException {
    Bet bet = service.createBet(email, teamId, amount);
    return convertToDto(bet);
  }

  @GetMapping(value = {"/bet/{id}", "/bet/{id}/"})
  public BetDto getBet(@PathVariable("id") long id)
      throws IllegalArgumentException {
    return convertToDto(service.getBet(id));
  }

  @PatchMapping(value = {"/bet/{id}/token", "/bet/{id}/token/"})
  public BetDto updateAmount(@PathVariable("id") long id,
                                @RequestParam int newAmount)
      throws IllegalArgumentException {
    Bet bet = service.getBet(id);
    bet = service.setAmount(id, newAmount);
    return convertToDto(bet);
  }

  @DeleteMapping(value = {"/bet/{id}", "/bet/{id}/"})
  public void deleteBet(@PathVariable("id") long id)
      throws IllegalArgumentException {
    service.deleteBet(id);
  }

}
