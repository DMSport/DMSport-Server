package com.project.dmsport.domain.user.presentation.dto.response;

import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInfoResponse {
    private final String name;
    private final String email;
    private final Authority authority;
}
