package br.com.cezarcruz.dojomars.domain;

public enum Bussola {

  NORTE('N', 'W', 'E'),
  SUL('S', 'E', 'W'),
  LESTE('E', 'N', 'S'),
  OESTE('W', 'S', 'N');

  private final char atual;
  private final char esquerda;
  private final char direita;

  Bussola(final char atual, final char esquerda, final char direita) {
    this.atual = atual;
    this.esquerda = esquerda;
    this.direita = direita;
  }

  public static Bussola get(final char cordenada) {

    for (final Bussola value : Bussola.values()) {
      if (value.getAtual() == cordenada) {
        return value;
      }
    }

    return Bussola.NORTE;
  }

  public char getAtual() {
    return atual;
  }

  public char getEsquerda() {
    return esquerda;
  }

  public char getDireita() {
    return direita;
  }
}
