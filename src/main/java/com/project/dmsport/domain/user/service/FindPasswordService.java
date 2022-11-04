package com.project.dmsport.domain.user.service;

import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.repository.UserRepository;
import com.project.dmsport.domain.user.facade.AuthCodeFacade;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.FindPasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FindPasswordService {

    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void execute(FindPasswordRequest request) {

        authCodeFacade.checkIsVerified(request.getEmail());

        User user = userFacade.getUserByEmail(request.getEmail());
        user.updatePassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }
}