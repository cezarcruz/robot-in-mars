package br.com.cezarcruz.dojomars.services;

import br.com.cezarcruz.dojomars.exception.InvalidCommandException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ValidateCommandService {

  private static final String PATTERN = "^[rlmRLM]+$";

  public void validate(final String command) {

    if (StringUtils.isEmpty(command)
        || !command.matches(PATTERN)) {
      throw new InvalidCommandException("Command invalid");
    }
  }
}
