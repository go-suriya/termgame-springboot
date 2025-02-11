package com.twentyone.termgame.user.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateDto {

  @NotBlank(message = "username is required")
  @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
  private String username;

  @NotBlank(message = "password is required")
  private String password;

  @NotBlank(message = "firstName is required")
  private String firstName;

  @NotBlank(message = "lastName is required")
  private String lastName;

  @NotBlank(message = "phoneNumber is required")
  private String phoneNumber;

  private BigDecimal point = BigDecimal.ZERO;
}
