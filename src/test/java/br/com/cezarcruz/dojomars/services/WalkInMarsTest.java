package br.com.cezarcruz.dojomars.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
  @CsvSource({"MM,'(0,2,N)'", "MML,'(0,2,W)'", "MML,'(0,2,W)'", "MMRMMRMM,'(2,0,S)'"})
  public void shouldMove(final String input, final String expected) {
    assertThat(walkInMarsService.walk(input), is(expected));
  }

  @ParameterizedTest
  @CsvSource({"MMMMMMMMMMMMMMMMMMMMMMMM,erro", "AAA,erro"})
  public void shouldNotMove(final String input, final String expected) {
    assertThat(walkInMarsService.walk(input), is(expected));
  }
}
