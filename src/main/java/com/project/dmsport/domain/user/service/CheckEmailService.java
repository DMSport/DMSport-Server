package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.user.exception.UserAlreadyExistException;
import com.project.dmsport.domain.user.facade.AuthCodeFacade;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.CheckEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckEmailService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional(readOnly = true)
    public void execute(CheckEmailRequest request) {

        String email = request.getEmail();

        authCodeFacade.checkEmailDomain(email);

        if(userFacade.emailIsExist(email)) {
            throw UserAlreadyExistException.EXCEPTION;
        }
    }

}