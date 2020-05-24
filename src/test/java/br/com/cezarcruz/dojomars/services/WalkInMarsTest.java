package br.com.cezarcruz.dojomars.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.cezarcruz.dojomars.exception.InvalidPositionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
      "MMMMRMMMMRMMMMRMMMMR,'(0,0,N)'",
      "RRRR,'(0,0,N)'",
      "MMRMMRMML,'(2,0,E)'",
      "MMRMMRMM,'(2,0,S)'",
      "MMRMMRMMR,'(2,0,W)'",
      "MMMMRMMRMMLMMRMMRMMMRMLM, '(0,1,W)'",
      "MMMMRMML, '(2,4,N)'",
      "MMMML, '(0,4,W)'",
  })
  public void shouldMove(final String input, final String expected) {
    assertThat(walkInMarsService.walk(input), is(expected));
  }

  @ParameterizedTest
  @ValueSource(strings = {
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


}
