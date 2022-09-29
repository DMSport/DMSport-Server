package com.project.dmsport.domain.user.service;


import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.repository.UserRepository;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.WithdrawalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(WithdrawalRequest request) {

        User user = userFacade.getCurrentUser();

        userFacade.checkPassword(user, request.getPassword());

        userRepository.delete(user);
    }
}