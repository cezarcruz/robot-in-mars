package br.com.cezarcruz.dojomars.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.cezarcruz.dojomars.exception.InvalidCommandException;
import br.com.cezarcruz.dojomars.exception.InvalidPositionException;
import br.com.cezarcruz.dojomars.sercices.WalkInMarsService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WalkInMarsTest {

  @Autowired
  private WalkInMarsService walkInMarsService;

  @ParameterizedTest
  @CsvSource({
      "MM,'(0,2,N)'",
      "MML,'(0,2,W)'",
      "MML,'(0,2,W)'",
      "MMRMMRMM,'(2,0,S)'",
      "MMMMMRMMMMMRMMMMMRMMMMMR,'(0,0,N)'",
      "RRRR,'(0,0,N)'",
  })
  public void shouldMove(final String input, final String expected) {
    assertThat(walkInMarsService.walk(input), is(expected));
  }

  @ParameterizedTest
  @CsvSource({
      "MMMMMMMMMMMMMMMMMMMMMMMM",
      "LMM",
      "MMMMMM",
      "MMMMMLM",
      "LM",
      "LLM",
      "RMMMMMM"
  })
  public void shouldNotMove(final String input) {
    assertThrows(InvalidPositionException.class, () -> walkInMarsService.walk(input));
  }

  @ParameterizedTest
  @CsvSource({
      "AAA",
      "ALL",
      "VMM"
  })
  public void shouldVerifyInvalidParameters(final String input) {
    assertThrows(InvalidCommandException.class, () -> walkInMarsService.walk(input));
  }
}
