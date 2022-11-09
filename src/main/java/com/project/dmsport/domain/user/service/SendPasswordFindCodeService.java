package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.user.exception.UserNotFoundException;
import com.project.dmsport.domain.user.facade.AuthCodeFacade;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.SendAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendPasswordFindCodeService {

    private final AuthCodeFacade authCodeFacade;
    private final UserFacade userFacade;

    public void execute(SendAuthCodeRequest request) {

        String email = request.getEmail();

        if (!userFacade.emailIsExist(email)) {
            throw UserNotFoundException.EXCEPTION;
        }
        authCodeFacade.sendMail(email);
    }
}