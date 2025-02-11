package com.twentyone.termgame.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {

    // private StatusDto status;
    
    private Boolean result;
    private String message;
    private int statusCode;
    private T data;
    private T error;

}

