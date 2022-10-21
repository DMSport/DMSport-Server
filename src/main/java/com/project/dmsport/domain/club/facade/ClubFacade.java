package com.project.dmsport.domain.club.facade;

import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.domain.repository.ClubRepository;
import com.project.dmsport.domain.club.domain.repository.ClubScheduleRepository;
import com.project.dmsport.domain.club.exception.ClubNotFoundException;
import com.project.dmsport.domain.club.exception.ClubScheduleAlreadyExistException;
import com.project.dmsport.domain.user.domain.enums.Authority;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@RequiredArgsConstructor
@Component
public class ClubFacade {

    private final ClubRepository clubRepository;
    private final ClubScheduleRepository clubScheduleRepository;

    public Club getClubById(ClubType clubType) {
        return clubRepository.findById(clubType)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);
    }

    public Authority convertClubTypeToAuthority(ClubType clubType) {
        String authority = clubType + "_MANAGER";
        return Authority.valueOf(authority);
    }

    public void checkScheduleExists(ActivityPlace activityPlace, DayOfWeek dayOfWeek, VoteType voteType) {
        if(clubScheduleRepository.existsByActivityPlaceAndDayOfWeekAndVoteType(activityPlace,dayOfWeek,voteType)) {
            throw ClubScheduleAlreadyExistException.EXCEPTION;
        }
    }

}
