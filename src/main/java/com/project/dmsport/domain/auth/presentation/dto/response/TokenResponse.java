package com.project.dmsport.domain.auth.presentation.dto.response;

import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;

    private final LocalDateTime expiredAt;

    private final String refreshToken;

    private final Authority authority;

}