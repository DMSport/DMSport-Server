package com.project.dmsport.domain.club.facade;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.club.exception.ClubNotFoundException;
import com.project.dmsport.domain.user.domain.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private final ClubRepository clubRepository;

    public Club getClubByClubType(ClubType clubType) {
        return clubRepository.findByClubType(clubType)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);
    }

    public Authority convertClubTypeToAuthority(ClubType clubType) {
        String authority = clubType + "_MANAGER";
        return Authority.valueOf(authority);
    }

}
