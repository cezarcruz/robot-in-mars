package br.com.cezarcruz.dojomars.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RobotControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private static final String URL = "/rest/mars/";

  @ParameterizedTest
  @CsvSource({
      "MM,'(0,2,N)'",
      "MML,'(0,2,W)'",
      "MML,'(0,2,W)'",
      "MMRMMRMM,'(2,0,S)'",
      "MMMMRMMMMRMMMMRMMMMR,'(0,0,N)'",
      "RRRR,'(0,0,N)'"
  })
  public void shouldMove(final String input, final String expected) throws Exception {

    mockMvc.perform(post(URL + input))
        .andExpect(status().isOk())
        .andExpect(content().string(expected));
  }

  @ParameterizedTest
  @CsvSource({
      "MMMMMMMMMMMMMMMMMMMMMMMM",
      "LMM",
      "MMMMMM",
      "MMMMMLM",
      "MMMMRMMMMRMMMMRMMMMMR",
  })
  public void shouldNotMove(final String input) throws Exception {

    mockMvc.perform(post(URL + input))
        .andExpect(status().isBadRequest())
        .andExpect(content().string("400 Bad Request"));

  }

  @ParameterizedTest
  @CsvSource({
      "AAA",
      "ALL",
      "VMM"
  })
  public void shouldVerifyInvalidParameters(final String input) throws Exception {
    mockMvc.perform(post(URL + input))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(content().string("400 Bad Request"));
  }

}
