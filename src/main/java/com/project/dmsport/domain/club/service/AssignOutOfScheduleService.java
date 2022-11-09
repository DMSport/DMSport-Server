package com.project.dmsport.domain.club.service;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssignOutOfScheduleService {
    private final ClubFacade clubFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute() {
        String auth = userFacade.getCurrentUser().getAuthority().toString();

        Club club = clubFacade.getClubById(
                ClubType.valueOf(auth.replace("_MANAGER", "")));

        club.toggleHope();
    }
}