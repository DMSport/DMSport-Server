package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.response.QueryMyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryMyInfoService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyInfoResponse execute() {
        User user = userFacade.getCurrentUser();
        return QueryMyInfoResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .authority(user.getAuthority())
                .build();
    }
}
