package br.com.cezarcruz.dojomars.sercices;

import br.com.cezarcruz.dojomars.domain.Robot;
import br.com.cezarcruz.dojomars.exception.InvalidCommandException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class WalkInMarsService {

  public static final char MOVE = 'M';
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';

  public String walk(final String command) {

    final String pattern = "^[rlmRLM]+$";

    if (StringUtils.isEmpty(command)
        || !command.matches(pattern)) {
      throw new InvalidCommandException("Command invalid");
    }

    final Robot robot = Robot.inMars("Mars1");

    for (final Character c : command.toCharArray()) {
      if (c.equals(MOVE)) {
        robot.move();
      }

      if (c.equals(LEFT)) {
        robot.turnLeft();
      }

      if (c.equals(RIGHT)) {
        robot.turnRight();
      }

    }

    return (String.format("(%s,%s,%s)", robot.getPosition().getX(), robot.getPosition().getY(), robot
            .getPosition().getCompass().getActual()));

  }

}
