package com.twentyone.termgame.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private Boolean result;
    private int statusCode;
    private String message;
    private T data;
    private T error;
}

