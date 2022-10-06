package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.request.ClubBanRequest;
import com.project.dmsport.domain.admin.presentation.dto.response.ClubBanResponse;
import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ClubBanService {

    private final ClubRepository clubRepository;

    @Transactional
    public ClubBanResponse execute(ClubBanRequest request) {

        ClubType clubType = request.getClubType();
        LocalDate banPeriod = request.getBanPeriod();

        Club club = clubRepository.findByClubType(clubType)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        club.stopClub(banPeriod);

        return ClubBanResponse.builder()
                .ban(club.isBan())
                .banPeriod(club.getBanPeriod())
                .build();
    }

}
