package com.twentyone.termgame.auth.service.impl;

import com.twentyone.termgame.auth.dto.request.LoginUserDto;
import com.twentyone.termgame.auth.dto.response.LoginUseResponseDto;
import com.twentyone.termgame.common.security.JwtUtil;
import com.twentyone.termgame.user.model.entity.UserEntity;
import com.twentyone.termgame.user.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginUseResponseDto authenticate(LoginUserDto loginUserDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(), loginUserDto.getPassword()));

            var prepareUser = userRepository.findByUsernameToLogin(loginUserDto.getUsername());
            String accessToken = jwtUtil.generateToken(loginUserDto.getUsername(), convertUserEntityToMap(prepareUser.get()));

            LoginUseResponseDto loginUseResponseDto = LoginUseResponseDto.builder()
                    .accessToken(accessToken)
                    .build();

            return loginUseResponseDto;
        } catch (Exception e) {
            System.out.println("Logging error: " + e);
            throw e;
        }
    }

    private Map<String, Object> convertUserEntityToMap(UserEntity user) {
        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("firstName", user.getFirstName());
        response.put("lastName", user.getLastName());
        return response;
    }
}
