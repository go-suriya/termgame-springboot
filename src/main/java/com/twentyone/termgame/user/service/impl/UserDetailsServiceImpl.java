package com.twentyone.termgame.user.service.impl;

import com.twentyone.termgame.common.exception.CustomException;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<UserEntity> prepareUser = userRepository.findByUsername(username);

            if (prepareUser.isEmpty()) {
                throw new CustomException("User Not found.", HttpStatus.NOT_FOUND);
            }

            return prepareUser.get();
        } catch (Exception e) {
            throw e;
        }
    }
}