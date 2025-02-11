package com.twentyone.termgame.common.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.twentyone.termgame.common.model.dto.ResponseDto;
import com.twentyone.termgame.common.model.enums.Status;

// @Slf4j
// @RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(CommonException.class)
  public ResponseEntity<ResponseDto<?>> handleClientErrorException(CommonException e) {
    Status status = e.getStatus();
    String message = StringUtils.isEmpty(e.getMessage()) ? null : e.getMessage();
    String messageError = e.getCause().getMessage();
    return createResponse(status, message, messageError);
  }

  private ResponseEntity<ResponseDto<?>> createResponse(Status status, String message, String messageError) {
    int httpStatus = status != null ? status.getHttpStatus() : 500;

    return ResponseEntity.status(httpStatus).body(
        ResponseDto.builder()
            .message(message)
            .statusCode(httpStatus)
            .result(Boolean.FALSE)
            .error(messageError)
            .build());
  }

}
