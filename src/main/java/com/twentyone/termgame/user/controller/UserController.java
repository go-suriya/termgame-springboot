package com.twentyone.termgame.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twentyone.termgame.user.dto.UserCreateDto;
import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping()
  public ResponseEntity<UserEntity> createUser(@RequestBody @Validated UserCreateDto body) {
      var newUser = userService.createUser(body);
      return ResponseEntity.created(null).body(newUser);
  }
  

}
