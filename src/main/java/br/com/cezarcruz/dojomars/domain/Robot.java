package br.com.cezarcruz.dojomars.domain;

import br.com.cezarcruz.dojomars.exception.InvalidPositionException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Robot {

  private final String name;
  private final Place planet;
  private Position position;

  public static Robot inMars(final String name) {
    return Robot.builder()
        .name(name)
        .position(Position.initialPosition())
        .planet(Mars.newPlace())
        .build();
  }

  public void move() {
    final Position newPosition = this.position.move();

    if (this.planet.canMove(newPosition.getX(), newPosition.getY())) {
      this.position = newPosition;
    } else {
      throw new InvalidPositionException("Cant move to this place");
    }

  }

  public void turnLeft() {
    this.position = this.position.toBuilder()
        .compass(this.getPosition().turnLeft())
        .build();
  }

  public void turnRight() {
    this.position = this.position.toBuilder()
        .compass(this.getPosition().turnRight())
        .build();
  }
}
