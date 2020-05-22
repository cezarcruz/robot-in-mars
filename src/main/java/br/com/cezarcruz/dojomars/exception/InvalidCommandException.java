package br.com.cezarcruz.dojomars.exception;

public class InvalidCommandException extends RuntimeException {

  public InvalidCommandException(final String message) {
    super(message);
  }
}
