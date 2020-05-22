package br.com.cezarcruz.dojomars.domain;

public enum Bussola {

  NORTE('N', 'W', 'E');

  private final Character atual;
  private final Character esquerda;
  private final Character direita;

  Bussola(final Character atual, final Character esquerda, final Character direita) {
    this.atual = atual;
    this.esquerda = esquerda;
    this.direita = direita;
  }

}
