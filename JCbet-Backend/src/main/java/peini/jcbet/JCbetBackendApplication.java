package peini.jcbet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class JCbetBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(JCbetBackendApplication.class, args);
  }

  @RequestMapping("/")
  public String greeting() {
    return "hello";
  }

}
