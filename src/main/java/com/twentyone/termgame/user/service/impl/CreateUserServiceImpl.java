package com.twentyone.termgame.user.service.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twentyone.termgame.common.exception.CustomException;
import com.twentyone.termgame.user.dto.request.UserCreateRequestDto;
import com.twentyone.termgame.user.dto.response.UserCreateResponseDto;
import com.twentyone.termgame.user.mapper.UserMapper;
import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.repository.UserRepository;
import com.twentyone.termgame.user.service.CreateUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserCreateResponseDto createUser(UserCreateRequestDto body) throws CustomException {
        try {
            Optional<UserEntity> optionalUser = userRepository.findByUsername(body.getUsername());

            if (optionalUser.isPresent()) {
                throw new CustomException("Username already exists.", HttpStatus.BAD_REQUEST);
            }

            var prepareUser = userMapper.toUserEntity(body);
            prepareUser.setCreatedBy(body.getUsername());

            var newUser = userRepository.save(prepareUser);
            var responseUserDto = userMapper.userEntityToUserCreateResponseDto(newUser);

            return responseUserDto;
        } catch (Exception e) {
            System.out.println("Logging error: " + e);
            throw e;
        }
    }
}
