package br.com.cezarcruz.dojomars.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Compass {

  NORTH('N', 'W', 'E'),
  SOUTH('S', 'E', 'W'),
  EAST('E', 'N', 'S'),
  WEST('W', 'S', 'N');

  private final char actual;
  private final char left;
  private final char right;

  public static Compass get(final char coordinate) {

    for (final Compass value : Compass.values()) {
      if (value.getActual() == coordinate) {
        return value;
      }
    }

    return Compass.NORTH;
  }

  public static Compass initialCoordinate() {
    return NORTH;
  }

}
