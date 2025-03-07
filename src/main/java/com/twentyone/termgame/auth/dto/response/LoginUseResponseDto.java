package com.twentyone.termgame.auth.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUseResponseDto {
    private String accessToken;
}
