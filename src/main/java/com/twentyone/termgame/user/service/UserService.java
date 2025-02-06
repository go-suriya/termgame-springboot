package com.twentyone.termgame.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twentyone.termgame.user.dto.UserCreateDto;
import com.twentyone.termgame.user.mapper.UserMapper;
import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  @Transactional
  public UserEntity createUser(UserCreateDto body) {
    var prepareUser = userMapper.toUserEntity(body);
    var newUser = userRepository.save(prepareUser);
    return newUser;
  }

}
