package com.twentyone.termgame.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twentyone.termgame.common.exception.CommonException;
import com.twentyone.termgame.user.dto.UserCreateDto;
import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.service.CreateUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final CreateUserService createUserService;
  @PostMapping()
  public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserCreateDto body) throws CommonException {
    var newUser = createUserService.createUser(body);
    return ResponseEntity.created(null).body(newUser);
  }

}
