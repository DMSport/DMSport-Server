package com.project.dmsport.domain.club.presentation.response;

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
    private final List<VoteResponse> vote;

    @Getter
    @Builder
    public static class VoteResponse {
        private final Long voteId;
        private final VoteType voteType;
        private final Integer voteCount;
    }

}
