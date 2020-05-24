package br.com.cezarcruz.dojomars.services;

import br.com.cezarcruz.dojomars.domain.Robot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WalkInMarsService {

  public static final char MOVE = 'M';
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';

  public String walk(final String command) {

    final Robot robot = Robot.inMars("Mars1");

    for (final Character c : command.toCharArray()) {
      switch (c) {
        case MOVE:
          robot.move();
          break;
        case LEFT:
          robot.turnLeft();
          break;
        case RIGHT:
          robot.turnRight();
          break;
      }

    }

    return (String.format("(%s,%s,%s)", robot.getPosition().getX(), robot.getPosition().getY(), robot
            .getPosition().getCompass().getActual()));

  }

}
