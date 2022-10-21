package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.request.AssignClubDayRequest;
import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.ClubSchedule;
import com.project.dmsport.domain.club.domain.enums.ActivityPlace;
import com.project.dmsport.domain.club.domain.repository.ClubScheduleRepository;
import com.project.dmsport.domain.club.facade.ClubFacade;
import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;

@RequiredArgsConstructor
@Service
public class AssignClubDayService {

    private final ClubScheduleRepository clubScheduleRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void execute(AssignClubDayRequest request) {

        Club club = clubFacade.getClubById(request.getClubType());
        ActivityPlace activityPlace = request.getActivityPlace();
        DayOfWeek dayOfWeek = request.getDayOfWeek();
        VoteType voteType = request.getVoteType();

        clubFacade.checkScheduleExists(activityPlace, dayOfWeek, voteType);

        clubScheduleRepository.save(ClubSchedule.builder()
                .activityPlace(request.getActivityPlace())
                .dayOfWeek(request.getDayOfWeek())
                .voteType(request.getVoteType())
                .club(club)
                .build());
    }

}
