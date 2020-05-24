package br.com.cezarcruz.dojomars.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.cezarcruz.dojomars.exception.InvalidCommandException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidateCommandServiceTest {

  @Autowired
  private ValidateCommandService validateCommandService;

  @ParameterizedTest
  @ValueSource(strings = {
      "AAA",
      "ALL",
      "VMM"
  })
  public void shouldVerifyInvalidParameters(final String input) {
    assertThrows(InvalidCommandException.class, () -> validateCommandService.validate(input));
  }

}
