package br.com.cezarcruz.dojomars.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
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

    if (x > sizeX || y > sizeY) {
      return false;
    }

    return true;
  }

  public static Place newPlace() {
    return Mars.builder()
        .min(0)
        .sizeX(5)
        .sizeY(5)
        .build();
  }

}
