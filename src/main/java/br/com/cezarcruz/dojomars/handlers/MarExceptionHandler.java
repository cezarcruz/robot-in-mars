package br.com.cezarcruz.dojomars.handlers;


import br.com.cezarcruz.dojomars.exception.InvalidCommandException;
import br.com.cezarcruz.dojomars.exception.InvalidPositionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MarExceptionHandler {

  @ExceptionHandler({InvalidCommandException.class, InvalidPositionException.class})
  public ResponseEntity<String> manufacturerNotFoundException(final RuntimeException e) {
    log.error("handling error", e);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
  }

}
