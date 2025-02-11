package com.twentyone.termgame.user.service;

import com.twentyone.termgame.common.exception.CommonException;
import com.twentyone.termgame.user.dto.UserCreateDto;
import com.twentyone.termgame.user.model.entity.UserEntity;

public interface CreateUserService {
    public UserEntity createUser(UserCreateDto body) throws CommonException;
}
