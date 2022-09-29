package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.user.exception.UserAlreadyExistException;
import com.project.dmsport.domain.user.facade.AuthCodeFacade;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.SendAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class SendSignupAuthCodeService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    public void execute(@Valid SendAuthCodeRequest request) {

        String email = request.getEmail();

        if(userFacade.emailIsExist(email)) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        authCodeFacade.sendMail(email);
    }
}