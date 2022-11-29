package com.project.dmsport.domain.vote.presentation;

import com.project.dmsport.domain.club.domain.enums.ClubType;
import com.project.dmsport.domain.vote.presentation.dto.response.QueryTodayVoteListResponse;
import com.project.dmsport.domain.vote.service.QueryTodayVoteListService;
import com.project.dmsport.domain.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/clubs")
@RestController
public class VoteController {

    private final VoteService voteService;
    private final QueryTodayVoteListService queryTodayVoteListService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/vote/{vote-id}")
    public void vote(@PathVariable(name = "vote-id") Long voteId) {
        voteService.execute(voteId);
    }

    @GetMapping("/vote")
    public QueryTodayVoteListResponse getVote(@RequestParam(value = "type") ClubType clubType) {
        return queryTodayVoteListService.execute(clubType);
    }

}
