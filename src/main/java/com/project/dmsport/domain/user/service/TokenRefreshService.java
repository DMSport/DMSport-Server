package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.auth.domain.RefreshToken;
import com.project.dmsport.domain.auth.domain.repository.RefreshTokenRepository;
import com.project.dmsport.domain.auth.exception.RefreshTokenNotFoundException;
import com.project.dmsport.domain.auth.presentation.dto.response.TokenResponse;
import com.project.dmsport.global.security.jwt.JwtProperties;
import com.project.dmsport.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse execute(String refreshToken) {

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String email = redisRefreshToken.getEmail();
        String newRefreshToken = jwtTokenProvider.createRefreshToken(email);

        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.createAccessToken(email);

        return TokenResponse
                .builder()
                .accessToken(newAccessToken)
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(newRefreshToken)
                .build();
    }
}