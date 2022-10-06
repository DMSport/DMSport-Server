package com.project.dmsport.domain.admin.presentation.dto.response;

import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private final Long id;
    private final String name;
    private final Authority authority;
}
