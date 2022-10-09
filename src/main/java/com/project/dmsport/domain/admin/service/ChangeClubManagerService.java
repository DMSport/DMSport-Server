package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.request.ChangeClubManagerRequest;
import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.ClubManager;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubManagerRepository;
import com.project.dmsport.domain.club.exception.ClubManagerNotFoundException;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.user.domain.User;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChangeClubManagerService {

    private final ClubManagerRepository clubManagerRepository;
    private final UserFacade userFacade;
    private final ClubFacade clubFacade;

    @Transactional
    public void execute(ChangeClubManagerRequest request, Long userId) {

        ClubType clubType = request.getClubType();

        User newManagerUser = userFacade.getUserById(userId);
        Club club = clubFacade.getClubByClubType(clubType);

        ClubManager clubManager = clubManagerRepository.findById(club.getId())
                .orElseThrow(() -> ClubManagerNotFoundException.EXCEPTION);

        User oldManagerUser = clubManager.getUser();
        oldManagerUser.changeUserAuthority(Authority.USER);

        Authority authority = clubFacade.convertClubTypeToAuthority(clubType);
        newManagerUser.changeUserAuthority(authority);

        clubManager.changeClubManager(newManagerUser);
    }

}
