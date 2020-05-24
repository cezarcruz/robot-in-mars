package br.com.cezarcruz.dojomars.endpoint;

import br.com.cezarcruz.dojomars.services.ValidateCommandService;
import br.com.cezarcruz.dojomars.services.WalkInMarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

  @Autowired
  private WalkInMarsService walkInMarsService;

  @Autowired
  private ValidateCommandService validateCommandService;

  @PostMapping("/{command}")
  public ResponseEntity<String> walk(@PathVariable final String command) {

    validateCommandService.validate(command);

    final String result = walkInMarsService.walk(command);
    return ResponseEntity.ok(result);
  }

}
