package com.project.dmsport.domain.vote.presentation.dto.response;

import com.project.dmsport.domain.vote.domain.enums.VoteType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class QueryTodayVoteListResponse {

    private final boolean isBan;
    private final LocalDate banPeriod;
    private final Integer maxPeople;
    private final List<VoteResponse> voteList;

}
