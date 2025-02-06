package com.twentyone.termgame.user.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserCreateDto {

  private String username;

  private String password;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private BigDecimal point = BigDecimal.ZERO;
}
