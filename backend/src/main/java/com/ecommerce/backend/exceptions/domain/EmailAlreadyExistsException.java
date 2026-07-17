package com.ecommerce.backend.exceptions.domain;

public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException(String email) {
    super("Email já cadastrado: " + email);
  }
}
