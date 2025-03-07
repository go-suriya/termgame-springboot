package com.twentyone.termgame.user.service;

import com.twentyone.termgame.common.exception.CustomException;
import com.twentyone.termgame.user.dto.request.UserCreateRequestDto;
import com.twentyone.termgame.user.dto.response.UserCreateResponseDto;

public interface CreateUserService {
    public UserCreateResponseDto createUser(UserCreateRequestDto body) throws CustomException;
}
