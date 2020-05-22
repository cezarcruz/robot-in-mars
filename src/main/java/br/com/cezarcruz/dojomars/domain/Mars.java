package br.com.cezarcruz.dojomars.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class Mars implements Place {

  private final int sizeX;
  private final int sizeY;
  private final int min;

  public boolean canMove(final int x, final int y) {

    if (x < min || y < min) {
      return false;
    }

    return x <= sizeX && y <= sizeY;
  }

  public static Place newPlace() {
    return Mars.builder()
        .min(0)
        .sizeX(5)
        .sizeY(5)
        .build();
  }

}
