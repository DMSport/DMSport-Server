package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.request.ClubBanRequest;
import com.project.dmsport.domain.admin.presentation.dto.response.ClubBanResponse;
import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.facade.ClubFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ClubBanService {

    private final ClubFacade clubFacade;

    @Transactional
    public ClubBanResponse execute(ClubBanRequest request) {

        ClubType clubType = request.getClubType();
        LocalDate banPeriod = request.getBanPeriod();

        Club club = clubFacade.getClubByClubType(clubType);

        club.ban(banPeriod);
        
        return new ClubBanResponse(club.isBan(), club.getBanPeriod());
    }

}
