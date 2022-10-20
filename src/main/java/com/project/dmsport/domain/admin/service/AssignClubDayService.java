package com.project.dmsport.domain.admin.service;

import com.project.dmsport.domain.admin.presentation.dto.request.AssignClubDayRequest;
import com.project.dmsport.domain.club.domain.Club;
import com.project.dmsport.domain.club.domain.ClubSchedule;
import com.project.dmsport.domain.club.domain.repository.ClubScheduleRepository;
import com.project.dmsport.domain.club.facade.ClubFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AssignClubDayService {

    private final ClubScheduleRepository clubScheduleRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void execute(AssignClubDayRequest request) {

        Club club = clubFacade.getClubById(request.getClubType());

        clubScheduleRepository.save(ClubSchedule.builder()
                .activityPlace(request.getActivityPlace())
                .dayOfWeek(request.getDayOfWeek())
                .voteType(request.getVoteType())
                .club(club)
                .build());
    }

}
