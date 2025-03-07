package com.twentyone.termgame.auth.controller;

import com.twentyone.termgame.auth.dto.request.LoginUserDto;
import com.twentyone.termgame.auth.dto.response.LoginUseResponseDto;
import com.twentyone.termgame.auth.service.impl.LoginService;
import com.twentyone.termgame.common.dto.response.ResponseDto;
import com.twentyone.termgame.common.exception.CustomException;
import com.twentyone.termgame.user.dto.request.UserCreateRequestDto;
import com.twentyone.termgame.user.dto.response.UserCreateResponseDto;
import com.twentyone.termgame.user.service.CreateUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final CreateUserService createUserService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginUseResponseDto>> login(@Valid @RequestBody LoginUserDto loginUserDto) {
        var response = loginService.authenticate(loginUserDto);

        return ResponseEntity.ok().body(
                ResponseDto.<LoginUseResponseDto>builder()
                        .result(Boolean.TRUE)
                        .statusCode(HttpStatus.OK.value())
                        .data(response)
                        .message("Success")
                        .build()
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<UserCreateResponseDto> register(@Valid @RequestBody UserCreateRequestDto body)
            throws CustomException {
        var newUser = createUserService.createUser(body);
        return ResponseEntity.created(null).body(newUser);
    }
}