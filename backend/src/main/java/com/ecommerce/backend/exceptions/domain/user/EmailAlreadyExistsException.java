package com.ecommerce.backend.exceptions.domain.user;

public class EmailAlreadyExistsException extends RuntimeException {
  private final int status;

  public EmailAlreadyExistsException(String message, int status) {
    super(message);
    this.status = status;
  }

  public int getStatus() {
    return status;
  }

}
