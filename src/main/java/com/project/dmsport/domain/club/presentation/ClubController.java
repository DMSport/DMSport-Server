package com.project.dmsport.domain.club.presentation;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.club.presentation.response.QueryTodayVoteListResponse;
import com.project.dmsport.domain.club.presentation.response.QueryVoteHistoryListResponse;
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

    private final VoteService voteService;
    private final QueryTodayVoteListService queryTodayVoteListService;
    private final QueryVoteHistoryListService queryVoteHistoryListService;
    private final AssignOutOfScheduleService assignOutOfScheduleService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/vote/{vote-id}")
    public void vote(@PathVariable(name = "vote-id") Long voteId) {
        voteService.execute(voteId);
    }

    @GetMapping("/vote")
    public QueryTodayVoteListResponse getVote(@RequestParam(value = "type") ClubType clubType,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return queryTodayVoteListService.execute(clubType, date);
    }

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