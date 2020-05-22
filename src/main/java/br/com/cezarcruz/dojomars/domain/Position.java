package br.com.cezarcruz.dojomars.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Position {

  private final int x;
  private final int y;
  private final Compass compass;

  public static Position initialPosition() {
    return Position.builder()
        .x(0).y(0)
        .compass(Compass.initialCoordinate())
        .build();
  }

  public Position move() {
    if (compass == Compass.NORTH) {
      return this.toBuilder().y(this.y + 1).build();
    }

    if (compass == Compass.SOUTH) {
      return this.toBuilder().y(this.y - 1).build();
    }

    if (compass == Compass.WEST) {
      return this.toBuilder().x(this.x - 1).build();
    }

    if (compass == Compass.EAST) {
      return this.toBuilder().x(this.x + 1).build();
    }

    return this;
  }

  public Compass turnLeft() {
    return Compass.get(this.compass.getLeft());
  }

  public Compass turnRight() {
    return Compass.get(this.compass.getRight());
  }

}
