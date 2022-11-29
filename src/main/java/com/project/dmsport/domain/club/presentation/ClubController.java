package com.project.dmsport.domain.club.presentation;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.presentation.dto.response.QueryTodayVoteListResponse;
import com.project.dmsport.domain.vote.presentation.dto.response.QueryVoteHistoryListResponse;
import com.project.dmsport.domain.club.service.AssignOutOfScheduleService;
import com.project.dmsport.domain.vote.service.QueryTodayVoteListService;
import com.project.dmsport.domain.vote.service.QueryVoteHistoryListService;
import com.project.dmsport.domain.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/clubs")
@RestController
public class ClubController {

    private final QueryVoteHistoryListService queryVoteHistoryListService;
    private final AssignOutOfScheduleService assignOutOfScheduleService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/schedule/hope")
    public void outOfSchedule() {
        assignOutOfScheduleService.execute();
    }

    @GetMapping("/vote/history")
    public QueryVoteHistoryListResponse getVoteHistory(@RequestParam(value = "type") ClubType clubType) {
        return queryVoteHistoryListService.execute(clubType);
    }

}