package com.twentyone.termgame.common.exception;

import com.twentyone.termgame.common.model.enums.Status;

public class CommonException extends Exception {
  private Status status;
  private Boolean result;

  public Status getStatus() {
    return status;
  }

  public Boolean getResult() {
    return result;
  }

  // send message
  public CommonException(String message) {
    super(message);
  }

  // send message error cause
  public CommonException(Throwable cause) {
    super(cause);
  }

  // send message error cause
  public CommonException(Status status) {
    this.status = status;
  }

  public CommonException(Status status, String message) {
    super(message);
    this.status = status;
  }

  public CommonException(Status status, String message, Boolean result) {
    super(message);
    this.status = status;
    this.result = result;
  }

  public CommonException(Status status, Throwable cause) {
    super(cause);
    this.status = status;
  }

  public CommonException(String message, Throwable cause) {
    super(message, cause);
  }

  public CommonException(Status status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
  }
}
