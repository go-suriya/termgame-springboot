package com.twentyone.termgame.user.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateResponseDto {

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private BigDecimal point = BigDecimal.ZERO;
}
