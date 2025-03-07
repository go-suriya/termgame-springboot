package com.twentyone.termgame.auth.dto.request;

import lombok.Data;

@Data
public class LoginUserDto {
    private String username;
    private String password;
}
