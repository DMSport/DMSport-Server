package com.project.dmsport.domain.user.service;


import com.project.dmsport.domain.club.domain.repository.ClubManagerRepository;
import com.project.dmsport.domain.notice.domain.repository.NoticeRepository;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.repository.UserRepository;
import com.project.dmsport.domain.user.exception.ClubManagerException;
import com.project.dmsport.domain.user.exception.PasswordMismatchException;
import com.project.dmsport.domain.user.facade.UserFacade;
import com.project.dmsport.domain.user.presentation.dto.request.WithdrawalRequest;
import com.project.dmsport.domain.vote.domain.repository.VoteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    private final ClubManagerRepository clubManagerRepository;

    private final NoticeRepository noticeRepository;

    private final VoteUserRepository voteUserRepository;

    @Transactional
    public void execute(WithdrawalRequest request) {

        User user = userFacade.getCurrentUser();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        if(clubManagerRepository.existsByUser(user)) {
            throw ClubManagerException.EXCEPTION;
        }

        noticeRepository.deleteByUser(user);
        voteUserRepository.deleteByUser(user);

        userRepository.delete(user);
    }
}